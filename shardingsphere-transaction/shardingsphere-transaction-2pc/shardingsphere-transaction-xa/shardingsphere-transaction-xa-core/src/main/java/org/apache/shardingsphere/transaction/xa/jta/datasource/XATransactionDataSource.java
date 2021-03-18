/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.transaction.xa.jta.datasource;

import com.google.common.collect.Sets;
import org.apache.shardingsphere.infra.database.type.DatabaseType;
import org.apache.shardingsphere.transaction.xa.jta.connection.XAConnectionFactory;
import org.apache.shardingsphere.transaction.xa.spi.SingleXAResource;
import org.apache.shardingsphere.transaction.xa.spi.XATransactionManager;

import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.RollbackException;
import javax.transaction.Synchronization;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * XA transaction data source.
 */
public final class XATransactionDataSource implements AutoCloseable {
    
    private static final Set<String> CONTAINER_DATASOURCE_NAMES = Sets.newHashSet("AtomikosDataSourceBean", "BasicManagedDataSource");
    // ThreadLocal变量，用以保存当前线程所涉及到的Transaction对象列表
    private final ThreadLocal<Set<Transaction>> enlistedTransactions = ThreadLocal.withInitial(HashSet::new);
    
    private final DatabaseType databaseType;
    
    private final String resourceName;
    
    private final DataSource dataSource;
    
    private XADataSource xaDataSource;
    
    private XATransactionManager xaTransactionManager;
    
    public XATransactionDataSource(final DatabaseType databaseType, final String resourceName, final DataSource dataSource, final XATransactionManager xaTransactionManager) {
        this.databaseType = databaseType;
        this.resourceName = resourceName;
        this.dataSource = dataSource;
        if (!CONTAINER_DATASOURCE_NAMES.contains(dataSource.getClass().getSimpleName())) {
            xaDataSource = XADataSourceFactory.build(databaseType, dataSource);
            this.xaTransactionManager = xaTransactionManager;
            xaTransactionManager.registerRecoveryResource(resourceName, xaDataSource);
        }
    }
    
    /**
     * Get connection.
     *
     * @return XA transaction connection
     * @throws SQLException SQL exception
     * @throws SystemException system exception
     * @throws RollbackException rollback exception
     */
    public Connection getConnection() throws SQLException, SystemException, RollbackException {
        if (CONTAINER_DATASOURCE_NAMES.contains(dataSource.getClass().getSimpleName())) {
            return dataSource.getConnection();
        }
        // 从DataSource中创建一个普通的Connection对象
        Connection result = dataSource.getConnection();
        // 通过工厂方法将普通的Connection对象转化为对应的XAConnection对象
        XAConnection xaConnection = XAConnectionFactory.createXAConnection(databaseType, xaDataSource, result);
        // 从xaTransactionManager中获取transaction对象
        Transaction transaction = xaTransactionManager.getTransactionManager().getTransaction();
        // 判断当前线程中是否存在这个Transaction
        if (!enlistedTransactions.get().contains(transaction)) {
            // 将XAConnection中的XAResource与目标Transaction对象关联起来
            transaction.enlistResource(new SingleXAResource(resourceName, xaConnection.getXAResource()));
            //Transaction 中注册一个 Synchronization 接口
            transaction.registerSynchronization(new Synchronization() {
                @Override
                public void beforeCompletion() {
                    enlistedTransactions.get().remove(transaction);
                }
    
                @Override
                public void afterCompletion(final int status) {
                    enlistedTransactions.get().clear();
                }
            });
            enlistedTransactions.get().add(transaction);
        }
        return result;
    }
    
    @Override
    public void close() {
        if (!CONTAINER_DATASOURCE_NAMES.contains(dataSource.getClass().getSimpleName())) {
            xaTransactionManager.removeRecoveryResource(resourceName, xaDataSource);
        } else {
            close(dataSource);
        }
    }
    
    private void close(final DataSource dataSource) {
        try {
            Method method = dataSource.getClass().getDeclaredMethod("close");
            method.setAccessible(true);
            method.invoke(dataSource);
        } catch (final ReflectiveOperationException ignored) {
        }
    }
}

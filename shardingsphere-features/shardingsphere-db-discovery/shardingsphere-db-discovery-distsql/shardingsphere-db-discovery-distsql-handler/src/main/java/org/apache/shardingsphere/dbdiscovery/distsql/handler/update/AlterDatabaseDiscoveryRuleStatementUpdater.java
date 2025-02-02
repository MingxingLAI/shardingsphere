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

package org.apache.shardingsphere.dbdiscovery.distsql.handler.update;

import com.google.common.base.Preconditions;
import org.apache.shardingsphere.dbdiscovery.api.config.DatabaseDiscoveryRuleConfiguration;
import org.apache.shardingsphere.dbdiscovery.api.config.rule.DatabaseDiscoveryDataSourceRuleConfiguration;
import org.apache.shardingsphere.dbdiscovery.distsql.handler.converter.DatabaseDiscoveryRuleStatementConverter;
import org.apache.shardingsphere.dbdiscovery.distsql.handler.exception.DatabaseDiscoveryRuleNotExistedException;
import org.apache.shardingsphere.dbdiscovery.distsql.handler.exception.InvalidDatabaseDiscoveryTypesException;
import org.apache.shardingsphere.dbdiscovery.distsql.parser.segment.DatabaseDiscoveryRuleSegment;
import org.apache.shardingsphere.dbdiscovery.distsql.parser.statement.AlterDatabaseDiscoveryRuleStatement;
import org.apache.shardingsphere.dbdiscovery.spi.DatabaseDiscoveryType;
import org.apache.shardingsphere.infra.distsql.update.RDLAlterUpdater;
import org.apache.shardingsphere.infra.exception.rule.ResourceNotExistedException;
import org.apache.shardingsphere.infra.exception.rule.RuleDefinitionViolationException;
import org.apache.shardingsphere.infra.metadata.resource.ShardingSphereResource;
import org.apache.shardingsphere.infra.spi.ShardingSphereServiceLoader;
import org.apache.shardingsphere.infra.spi.typed.TypedSPIRegistry;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Alter database discovery rule statement updater.
 */
public final class AlterDatabaseDiscoveryRuleStatementUpdater implements RDLAlterUpdater<AlterDatabaseDiscoveryRuleStatement, DatabaseDiscoveryRuleConfiguration> {
    
    static {
        // TODO consider about register once only
        ShardingSphereServiceLoader.register(DatabaseDiscoveryType.class);
    }
    
    @Override
    public void checkSQLStatement(final String schemaName, final AlterDatabaseDiscoveryRuleStatement sqlStatement,
                                  final DatabaseDiscoveryRuleConfiguration currentRuleConfig, final ShardingSphereResource resource) throws RuleDefinitionViolationException {
        checkCurrentRuleConfiguration(schemaName, sqlStatement, currentRuleConfig);
        checkToBeAlteredRules(schemaName, sqlStatement, currentRuleConfig);
        checkToBeAlteredResources(schemaName, sqlStatement, resource);
        checkToBeAlteredDiscoveryType(sqlStatement);
    }
    
    private void checkCurrentRuleConfiguration(final String schemaName, final AlterDatabaseDiscoveryRuleStatement sqlStatement, 
                                               final DatabaseDiscoveryRuleConfiguration currentRuleConfig) throws DatabaseDiscoveryRuleNotExistedException {
        if (null == currentRuleConfig) {
            throw new DatabaseDiscoveryRuleNotExistedException(schemaName, getToBeAlteredRuleNames(sqlStatement));
        }
    }
    
    private void checkToBeAlteredRules(final String schemaName, final AlterDatabaseDiscoveryRuleStatement sqlStatement, 
                                       final DatabaseDiscoveryRuleConfiguration currentRuleConfig) throws DatabaseDiscoveryRuleNotExistedException {
        Collection<String> currentRuleNames = currentRuleConfig.getDataSources().stream().map(DatabaseDiscoveryDataSourceRuleConfiguration::getName).collect(Collectors.toSet());
        Collection<String> notExistedRuleNames = getToBeAlteredRuleNames(sqlStatement).stream().filter(each -> !currentRuleNames.contains(each)).collect(Collectors.toList());
        if (!notExistedRuleNames.isEmpty()) {
            throw new DatabaseDiscoveryRuleNotExistedException(schemaName, notExistedRuleNames);
        }
    }
    
    private Collection<String> getToBeAlteredRuleNames(final AlterDatabaseDiscoveryRuleStatement sqlStatement) {
        return sqlStatement.getRules().stream().map(DatabaseDiscoveryRuleSegment::getName).collect(Collectors.toList());
    }
    
    private void checkToBeAlteredResources(final String schemaName, final AlterDatabaseDiscoveryRuleStatement sqlStatement, final ShardingSphereResource resource) throws ResourceNotExistedException {
        Collection<String> notExistedResources = resource.getNotExistedResources(getToBeAlteredResourceNames(sqlStatement));
        if (!notExistedResources.isEmpty()) {
            throw new ResourceNotExistedException(schemaName, notExistedResources);
        }
    }
    
    private Collection<String> getToBeAlteredResourceNames(final AlterDatabaseDiscoveryRuleStatement sqlStatement) {
        Collection<String> result = new LinkedHashSet<>();
        sqlStatement.getRules().forEach(each -> result.addAll(each.getDataSources()));
        return result;
    }
    
    private void checkToBeAlteredDiscoveryType(final AlterDatabaseDiscoveryRuleStatement sqlStatement) throws InvalidDatabaseDiscoveryTypesException {
        Collection<String> notExistedDiscoveryTypes = getToBeAlteredDiscoveryTypeNames(sqlStatement).stream()
                .filter(each -> !TypedSPIRegistry.findRegisteredService(DatabaseDiscoveryType.class, each, new Properties()).isPresent()).collect(Collectors.toList());
        if (!notExistedDiscoveryTypes.isEmpty()) {
            throw new InvalidDatabaseDiscoveryTypesException(notExistedDiscoveryTypes);
        }
    }
    
    private Collection<String> getToBeAlteredDiscoveryTypeNames(final AlterDatabaseDiscoveryRuleStatement sqlStatement) {
        return sqlStatement.getRules().stream().map(DatabaseDiscoveryRuleSegment::getDiscoveryTypeName).collect(Collectors.toSet());
    }
    
    @Override
    public void updateCurrentRuleConfiguration(final String schemaName, final AlterDatabaseDiscoveryRuleStatement sqlStatement, final DatabaseDiscoveryRuleConfiguration currentRuleConfig) {
        dropRuleConfiguration(sqlStatement, currentRuleConfig);
        addRuleConfiguration(sqlStatement, currentRuleConfig);
    }
    
    private void dropRuleConfiguration(final AlterDatabaseDiscoveryRuleStatement sqlStatement, final DatabaseDiscoveryRuleConfiguration currentRuleConfig) {
        getToBeAlteredRuleNames(sqlStatement).forEach(each -> dropDataSourceRuleConfiguration(each, currentRuleConfig));
    }
    
    private void dropDataSourceRuleConfiguration(final String toBeDroppedRuleNames, final DatabaseDiscoveryRuleConfiguration currentRuleConfig) {
        Optional<DatabaseDiscoveryDataSourceRuleConfiguration> toBeDroppedDataSourceRuleConfig
                = currentRuleConfig.getDataSources().stream().filter(each -> each.getName().equals(toBeDroppedRuleNames)).findAny();
        Preconditions.checkState(toBeDroppedDataSourceRuleConfig.isPresent());
        currentRuleConfig.getDataSources().remove(toBeDroppedDataSourceRuleConfig.get());
        currentRuleConfig.getDiscoveryTypes().remove(toBeDroppedDataSourceRuleConfig.get().getDiscoveryTypeName());
    }
    
    private void addRuleConfiguration(final AlterDatabaseDiscoveryRuleStatement sqlStatement, final DatabaseDiscoveryRuleConfiguration currentRuleConfig) {
        DatabaseDiscoveryRuleConfiguration toBeAlteredRuleConfig = DatabaseDiscoveryRuleStatementConverter.convert(sqlStatement.getRules());
        currentRuleConfig.getDataSources().addAll(toBeAlteredRuleConfig.getDataSources());
        currentRuleConfig.getDiscoveryTypes().putAll(toBeAlteredRuleConfig.getDiscoveryTypes());
    }
    
    @Override
    public Class<DatabaseDiscoveryRuleConfiguration> getRuleConfigurationClass() {
        return DatabaseDiscoveryRuleConfiguration.class;
    }
    
    @Override
    public String getType() {
        return AlterDatabaseDiscoveryRuleStatement.class.getCanonicalName();
    }
}

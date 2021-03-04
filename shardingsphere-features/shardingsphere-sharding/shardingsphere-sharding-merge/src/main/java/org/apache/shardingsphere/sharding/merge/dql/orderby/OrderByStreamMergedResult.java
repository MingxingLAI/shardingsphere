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

package org.apache.shardingsphere.sharding.merge.dql.orderby;

import lombok.AccessLevel;
import lombok.Getter;
import org.apache.shardingsphere.infra.metadata.schema.ShardingSphereSchema;
import org.apache.shardingsphere.infra.binder.statement.dml.SelectStatementContext;
import org.apache.shardingsphere.infra.executor.sql.execute.result.query.QueryResult;
import org.apache.shardingsphere.infra.merge.result.impl.stream.StreamMergedResult;
import org.apache.shardingsphere.infra.binder.segment.select.orderby.OrderByItem;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Stream merged result for order by.
 */
public class OrderByStreamMergedResult extends StreamMergedResult {
    
    private final Collection<OrderByItem> orderByItems;
    
    @Getter(AccessLevel.PROTECTED)
    private final Queue<OrderByValue> orderByValuesQueue;
    
    @Getter(AccessLevel.PROTECTED)
    private boolean isFirstNext;
    
    public OrderByStreamMergedResult(final List<QueryResult> queryResults, final SelectStatementContext selectStatementContext, final ShardingSphereSchema schema) throws SQLException {
        orderByItems = selectStatementContext.getOrderByContext().getItems();
        orderByValuesQueue = new PriorityQueue<>(queryResults.size());
        orderResultSetsToQueue(queryResults, selectStatementContext, schema);
        isFirstNext = true;
    }
    
    private void orderResultSetsToQueue(final List<QueryResult> queryResults, final SelectStatementContext selectStatementContext, final ShardingSphereSchema schema) throws SQLException {
        for (QueryResult each : queryResults) {
            // 对于每一个结果集，构造一个OrderByValue对象
            OrderByValue orderByValue = new OrderByValue(each, orderByItems, selectStatementContext, schema);
            if (orderByValue.next()) {
                // 如果当前QueryResult有值，就把它放入Queue
                orderByValuesQueue.offer(orderByValue);
            }
        }
        setCurrentQueryResult(orderByValuesQueue.isEmpty() ? queryResults.get(0) : orderByValuesQueue.peek().getQueryResult());
    }
    
    @Override
    public boolean next() throws SQLException {
        // 对多个有序的数组进行排序，归并排序是最适合此场景的排序算法
        if (orderByValuesQueue.isEmpty()) {
            return false;
        }
        if (isFirstNext) {
            isFirstNext = false;
            return true;
        }
        // 获取Queue中第一个结果集
        OrderByValue firstOrderByValue = orderByValuesQueue.poll();
        // 丢地它的第一个结果，然后再返回到Queue中
        if (firstOrderByValue.next()) {
            //将每个结果集的当前数据值进行比较（通过实现 Java 的 Comparable 接口完成），
            // 并将其放入优先级队列。 每次获取下一条数据时，只需将队列顶端结果集的游标下移，
            // 并根据新游标重新进入优先级排序队列找到自己的位置即可。
            orderByValuesQueue.offer(firstOrderByValue);
        }
        if (orderByValuesQueue.isEmpty()) {
            return false;
        }
        // 设置Queue里面的第一个元素为当前的结果集
        setCurrentQueryResult(orderByValuesQueue.peek().getQueryResult());
        return true;
    }
}

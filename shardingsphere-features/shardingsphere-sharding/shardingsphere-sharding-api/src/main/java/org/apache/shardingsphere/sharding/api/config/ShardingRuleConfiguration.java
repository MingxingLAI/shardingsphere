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

package org.apache.shardingsphere.sharding.api.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.infra.config.RuleConfiguration;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingAutoTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.ShardingStrategyConfiguration;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Sharding rule configuration.
 */
@Getter
@Setter
public final class ShardingRuleConfiguration implements RuleConfiguration {
    // 表分片规则列表，这也是必须要设置的配置项
    private Collection<ShardingTableRuleConfiguration> tables = new LinkedList<>();

    private Collection<ShardingAutoTableRuleConfiguration> autoTables = new LinkedList<>();
    // 绑定表规则列表
    private Collection<String> bindingTableGroups = new LinkedList<>();
    // 广播表规则列表
    private Collection<String> broadcastTables = new LinkedList<>();
    // 默认分库策略
    private ShardingStrategyConfiguration defaultDatabaseShardingStrategy;
    // 默认分表策略
    private ShardingStrategyConfiguration defaultTableShardingStrategy;
    // 默认自增列生成器
    private KeyGenerateStrategyConfiguration defaultKeyGenerateStrategy;
    
    private Map<String, ShardingSphereAlgorithmConfiguration> shardingAlgorithms = new LinkedHashMap<>();
    
    private Map<String, ShardingSphereAlgorithmConfiguration> keyGenerators = new LinkedHashMap<>();
}

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

package org.apache.shardingsphere.sharding.distsql.handler.exception;

import org.apache.shardingsphere.infra.exception.rule.RuleDefinitionViolationException;

/**
 * Sharding broadcast table rule not exists exception.
 */
public final class ShardingBroadcastTableRuleNotExistsException extends RuleDefinitionViolationException {
    
    private static final long serialVersionUID = 2816401356514609173L;
    
    public ShardingBroadcastTableRuleNotExistsException(final String schemaName) {
        super(1112, String.format("Sharding broadcast table rules do not exist in schema %s.", schemaName));
    }
}

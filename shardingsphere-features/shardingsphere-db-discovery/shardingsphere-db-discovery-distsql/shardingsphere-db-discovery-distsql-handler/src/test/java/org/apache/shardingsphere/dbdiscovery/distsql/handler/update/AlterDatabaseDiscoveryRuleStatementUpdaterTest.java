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

import org.apache.shardingsphere.dbdiscovery.api.config.DatabaseDiscoveryRuleConfiguration;
import org.apache.shardingsphere.dbdiscovery.api.config.rule.DatabaseDiscoveryDataSourceRuleConfiguration;
import org.apache.shardingsphere.dbdiscovery.distsql.handler.exception.DatabaseDiscoveryRuleNotExistedException;
import org.apache.shardingsphere.dbdiscovery.distsql.handler.exception.InvalidDatabaseDiscoveryTypesException;
import org.apache.shardingsphere.dbdiscovery.distsql.parser.segment.DatabaseDiscoveryRuleSegment;
import org.apache.shardingsphere.dbdiscovery.distsql.parser.statement.AlterDatabaseDiscoveryRuleStatement;
import org.apache.shardingsphere.infra.exception.rule.ResourceNotExistedException;
import org.apache.shardingsphere.infra.exception.rule.RuleDefinitionViolationException;
import org.apache.shardingsphere.infra.metadata.resource.ShardingSphereResource;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class AlterDatabaseDiscoveryRuleStatementUpdaterTest {
    
    private final AlterDatabaseDiscoveryRuleStatementUpdater updater = new AlterDatabaseDiscoveryRuleStatementUpdater();
    
    @Test(expected = DatabaseDiscoveryRuleNotExistedException.class)
    public void assertCheckSQLStatementWithoutCurrentRule() throws RuleDefinitionViolationException {
        updater.checkSQLStatement("foo", new AlterDatabaseDiscoveryRuleStatement(Collections.emptyList()), null, mock(ShardingSphereResource.class));
    }
    
    @Test(expected = DatabaseDiscoveryRuleNotExistedException.class)
    public void assertCheckSQLStatementWithoutToBeAlteredDatabaseDiscoveryRule() throws RuleDefinitionViolationException {
        updater.checkSQLStatement("foo", createSQLStatement("TEST"), 
                new DatabaseDiscoveryRuleConfiguration(Collections.emptyList(), Collections.emptyMap()), mock(ShardingSphereResource.class));
    }
    
    @Test(expected = ResourceNotExistedException.class)
    public void assertCheckSQLStatementWithoutExistedResources() throws RuleDefinitionViolationException {
        ShardingSphereResource resource = mock(ShardingSphereResource.class);
        when(resource.getNotExistedResources(any())).thenReturn(Collections.singleton("ds0"));
        updater.checkSQLStatement("foo", createSQLStatement("TEST"), createCurrentRuleConfiguration(), resource);
    }
    
    @Test(expected = InvalidDatabaseDiscoveryTypesException.class)
    public void assertCheckSQLStatementWithoutToBeAlteredDiscoveryTypes() throws RuleDefinitionViolationException {
        updater.checkSQLStatement("foo", createSQLStatement("INVALID_TYPE"), createCurrentRuleConfiguration(), mock(ShardingSphereResource.class));
    }
    
    @Test
    public void assertUpdateCurrentRuleConfiguration() {
        updater.updateCurrentRuleConfiguration("foo", createSQLStatement("TEST"), createCurrentRuleConfiguration());
        // TODO assert current rule configuration
    }
    
    private AlterDatabaseDiscoveryRuleStatement createSQLStatement(final String discoveryTypeName) {
        DatabaseDiscoveryRuleSegment ruleSegment = new DatabaseDiscoveryRuleSegment("ha_group", Arrays.asList("ds_0", "ds_1"), discoveryTypeName, new Properties());
        return new AlterDatabaseDiscoveryRuleStatement(Collections.singleton(ruleSegment));
    }
    
    private DatabaseDiscoveryRuleConfiguration createCurrentRuleConfiguration() {
        DatabaseDiscoveryDataSourceRuleConfiguration dataSourceRuleConfig = new DatabaseDiscoveryDataSourceRuleConfiguration("ha_group", Collections.emptyList(), "TEST");
        return new DatabaseDiscoveryRuleConfiguration(new LinkedList<>(Collections.singleton(dataSourceRuleConfig)), new HashMap<>());
    }
}

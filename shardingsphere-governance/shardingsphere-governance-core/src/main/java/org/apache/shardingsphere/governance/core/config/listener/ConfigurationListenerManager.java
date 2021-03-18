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

package org.apache.shardingsphere.governance.core.config.listener;

import org.apache.shardingsphere.governance.core.config.listener.metadata.MetaDataListener;
import org.apache.shardingsphere.governance.repository.api.ConfigurationRepository;
import org.apache.shardingsphere.governance.repository.api.listener.DataChangedEvent.Type;

import java.util.Collection;

/**
 * Configuration listener manager.
 */
public final class ConfigurationListenerManager {
    // 配置结构中3大顶层配置，分别是元数据、props和authentication
    private final MetaDataListener metaDataListener;
    
    private final PropertiesChangedListener propertiesChangedListener;
    
    private final AuthenticationChangedListener authenticationChangedListener;
    
    public ConfigurationListenerManager(final ConfigurationRepository configurationRepository, final Collection<String> schemaNames) {
        metaDataListener = new MetaDataListener(configurationRepository, schemaNames);
        propertiesChangedListener = new PropertiesChangedListener(configurationRepository);
        authenticationChangedListener = new AuthenticationChangedListener(configurationRepository);
    }
    
    /**
     * Initialize all configuration changed listeners.
     */
    public void initListeners() {
        metaDataListener.watch();
        propertiesChangedListener.watch(Type.UPDATED);
        authenticationChangedListener.watch(Type.UPDATED);
    }
}

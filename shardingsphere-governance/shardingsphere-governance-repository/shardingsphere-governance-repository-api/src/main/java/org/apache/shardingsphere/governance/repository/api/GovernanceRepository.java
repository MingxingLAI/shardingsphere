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

package org.apache.shardingsphere.governance.repository.api;

import org.apache.shardingsphere.infra.spi.typed.TypedSPI;
import org.apache.shardingsphere.governance.repository.api.config.GovernanceCenterConfiguration;
import org.apache.shardingsphere.governance.repository.api.listener.DataChangedEventListener;

import java.util.List;

/**
 * Governance repository.
 */
public interface GovernanceRepository extends TypedSPI {
    
    /**
     * Path separator.
     */
    String PATH_SEPARATOR = "/";
    
    /**
     * Dot separator.
     */
    String DOT_SEPARATOR = ".";
    
    /**
     * Initialize governance center.
     *
     * @param name governance center name
     * @param config governance center configuration
     */
    // 初始化配置中心
    void init(String name, GovernanceCenterConfiguration config);
    
    /**
     * Get data from governance center.
     *
     * <p>Maybe use cache if existed.</p>
     *
     * @param key key of data
     * @return value of data
     */
    // 获取配置项数据
    String get(String key);
    
    /**
     * Get node's sub-nodes list.
     *
     * @param key key of data
     * @return sub-nodes name list
     */
    // 获取子配置项列表
    List<String> getChildrenKeys(String key);
    
    /**
     * Persist data.
     *
     * @param key key of data
     * @param value value of data
     */
    // 持久化配置项
    void persist(String key, String value);
    
    /**
     * Delete node.
     *
     * @param key key of data
     */
    // 删除配置项
    void delete(String key);
    
    /**
     * Watch key or path of governance server.
     *
     * @param key key of data
     * @param listener data changed event listener
     */
    // 对配置项或者路径进行监听，这是最重要的函数，该函数传入了一个代表事件监听器的DataChangedEventListener接口
    void watch(String key, DataChangedEventListener listener);
    
    /**
     * Close.
     */
    // 关闭配置中心
    void close();
}

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

package org.apache.shardingsphere.proxy.backend.communication.jdbc.recognizer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.infra.exception.ShardingSphereException;
import org.apache.shardingsphere.proxy.backend.communication.jdbc.recognizer.spi.JDBCDriverComposeURLRecognizer;
import org.apache.shardingsphere.proxy.backend.communication.jdbc.recognizer.spi.JDBCDriverURLRecognizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ServiceLoader;

/**
 * JDBC driver URL recognizer engine.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JDBCDriverURLRecognizerEngine {
    // JDBC_DRIVER_URL_RECOGNIZERS保存了所有的识别器
    private static final Collection<JDBCDriverURLRecognizer> JDBC_DRIVER_URL_RECOGNIZERS = new LinkedList<>();
    
    static {
        // 这里直接使用的是ServiceLoader，ServiceLoader返回的是每一个类的实例
        for (JDBCDriverURLRecognizer each : ServiceLoader.load(JDBCDriverURLRecognizer.class)) {
            JDBC_DRIVER_URL_RECOGNIZERS.add(each);
        }
    }
    
    /**
     * Get JDBC driver URL recognizer.
     * 
     * @param url JDBC URL
     * @return JDBC driver URL recognizer
     */
    // 根据用户配置的URL，返回对应的数据库的识别器，以便调用不同的数据库驱动
    public static JDBCDriverURLRecognizer getJDBCDriverURLRecognizer(final String url) {
        // url的取值如 jdbc:mysql://9.134.193.40:3306/ds1?serverTimezone=UTC&useSSL=false
        JDBCDriverURLRecognizer result = JDBC_DRIVER_URL_RECOGNIZERS.stream().filter(each -> isMatchURL(url, each)).findAny()
                .orElseThrow(() -> new ShardingSphereException("Cannot resolve JDBC url `%s`. Please implements `%s` and add to SPI.", url, JDBCDriverURLRecognizer.class.getName()));
        if (result instanceof JDBCDriverComposeURLRecognizer) {
            return ((JDBCDriverComposeURLRecognizer) result).getDriverURLRecognizer(url);
        }
        return result;
    }
    
    private static boolean isMatchURL(final String url, final JDBCDriverURLRecognizer jdbcDriverURLRecognizer) {
        // Prefix理论上只会有一个，但是ShardingSphere为了扩展实现为一个Collection，因此，这里使用stream进行匹配
        return jdbcDriverURLRecognizer.getURLPrefixes().stream().anyMatch(url::startsWith);
    }
}

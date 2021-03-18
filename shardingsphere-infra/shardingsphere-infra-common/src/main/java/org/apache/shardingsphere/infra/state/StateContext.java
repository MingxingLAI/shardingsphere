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

package org.apache.shardingsphere.infra.state;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * State context.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StateContext {

    // 之所以使用一个Deque来保存状态，是为了便于状态的恢复
    private static final Deque<StateType> CURRENT_STATE = new ConcurrentLinkedDeque<>(Collections.singleton(StateType.OK));
    
    /**
     * Switch state.
     *
     * @param event state event
     */
    // 可以打开现在的状态，也可以关闭现在的状态。如果是关闭现在的状态，就恢复到上一次的状态
    public static void switchState(final StateEvent event) {
        if (event.isOn()) {
            CURRENT_STATE.push(event.getType());
        } else {
            if (getCurrentState() == event.getType()) {
                recoverState();
            }
        }
    }
    
    /**
     * Get current state.
     * 
     * @return current state
     */
    public static StateType getCurrentState() {
        // 如果状态为空，则返回默认状态StateType.OK
        return Optional.ofNullable(CURRENT_STATE.peek()).orElse(StateType.OK);
    }
    
    private static void recoverState() {
        CURRENT_STATE.pop();
    }
}

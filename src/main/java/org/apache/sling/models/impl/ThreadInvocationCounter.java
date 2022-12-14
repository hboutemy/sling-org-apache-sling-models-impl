/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.models.impl;

class ThreadInvocationCounter {

    private int count;
    private int max;
    private int overallCount;

    final int maxRecursionDepth;

    public ThreadInvocationCounter(int maxRecursionDepth) {
        this.maxRecursionDepth = maxRecursionDepth;
    }

    public void resetStats() {
        max = 0;
        overallCount = 0;
    }

    public int getMaxRecursion() {
        return max;
    }

    public int getOverallCount() {
        return overallCount;
    }

    public boolean isMaximumReached() {
        return count >= maxRecursionDepth;
    }

    public void increase() {
        this.count++;
        this.overallCount++;
        if (count > max) {
            max = count;
        }
    }

    public void decrease() {
        this.count--;
    }
}
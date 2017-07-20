/**
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.boot.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import io.micrometer.core.instrument.binder.MeterBinder;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * @author Jon Schneider
 */
@Configuration
public class MeterBinderRegistration {
    @Autowired
    MeterRegistry registry;

    @Autowired(required = false)
    Collection<MeterBinder> binders;

    @PostConstruct
    void bindAll() {
        for (MeterBinder binder : binders) {
            binder.bindTo(registry);
        }
    }
}
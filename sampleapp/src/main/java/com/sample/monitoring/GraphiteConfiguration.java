package com.sample.monitoring;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.util.HierarchicalNameMapper;
import io.micrometer.graphite.GraphiteConfig;
import io.micrometer.graphite.GraphiteMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphiteConfiguration {

    @Bean
    public GraphiteMeterRegistry graphiteMeterRegistry() {
        return new GraphiteMeterRegistry(
                GraphiteConfig.DEFAULT,
                Clock.SYSTEM,
                (id, convention) -> "myapp." + HierarchicalNameMapper.DEFAULT.toHierarchicalName(id, convention));
    }


}

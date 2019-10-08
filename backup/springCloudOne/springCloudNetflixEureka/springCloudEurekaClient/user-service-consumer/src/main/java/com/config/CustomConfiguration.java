package com.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/*
 *CustomConfiguration
 *
 *@author 87990
 *@email
 *@date 2019/10/6
 */
@Configuration
public class CustomConfiguration {
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        RoundRobinRule rule = new RoundRobinRule();
       rule.initWithNiwsConfig(config);
        return rule;
    }
}

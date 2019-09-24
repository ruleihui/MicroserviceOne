package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *SpringCloundConfigClient
 *
 *@author 87990
 *@email
 *@date 2019/9/23
 */
@SpringBootApplication
public class SpringCloudConfigClient {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringCloudConfigClient.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args);
    }

    @Configuration
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static class CustomPropertySourceLocator implements PropertySourceLocator {

        @Override
        public PropertySource<?> locate(Environment environment) {
            Map<String, Object> source = new HashMap<>();
            source.put("server.port", "9090");
            MapPropertySource propertySource = new MapPropertySource("custom-property-source", source);
            return propertySource;
        }

    }
}

package com.xgl;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.discovery.converters.Auto;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration;
import org.springframework.cloud.netflix.ribbon.*;
import org.springframework.cloud.netflix.ribbon.apache.HttpClientRibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.okhttp.OkHttpRibbonConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import static org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration.*;

/*
 *UserServiceConsumerBootstrap
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceConsumerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumerBootstrap.class, args);
    }





    @Bean
    @LoadBalanced
    public RestTemplate customRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
//        SpringClientFactory springClientFactory = new SpringClientFactory();
//        RibbonLoadBalancerClient ribbonLoadBalancerClient = new RibbonLoadBalancerClient(springClientFactory);
//        LoadBalancerInterceptor loadBalancerInterceptor = new LoadBalancerInterceptor(ribbonLoadBalancerClient);
//        restTemplate.getInterceptors().add(loadBalancerInterceptor);
        return restTemplate;
    }
}

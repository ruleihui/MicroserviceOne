package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/*
 *HystrixClientDemo
 *
 *@author 87990
 *@email
 *@date 2019/10/2
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableTurbine
public class HystrixClientDemo {
    public static void main(String[] args) {
        SpringApplication.run(HystrixClientDemo.class, args);
    }
}

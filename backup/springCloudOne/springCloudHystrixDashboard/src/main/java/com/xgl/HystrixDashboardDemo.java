package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/*
 *HystrixDashboardDemo
 *
 *@author 87990
 *@email
 *@date 2019/10/5
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardDemo {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardDemo.class, args);
    }
}

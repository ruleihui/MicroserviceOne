package com.xgl.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

/*
 *SpringCloudEurekaServer
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@SpringBootApplication
@EnableEurekaServer
@PropertySource("")
public class SpringCloudEurekaServer {
    public static void main(String[] args) {
//        args=new String[]{"--spring.profiles.active=peer3"};
        SpringApplication.run(SpringCloudEurekaServer.class, args);
    }
}

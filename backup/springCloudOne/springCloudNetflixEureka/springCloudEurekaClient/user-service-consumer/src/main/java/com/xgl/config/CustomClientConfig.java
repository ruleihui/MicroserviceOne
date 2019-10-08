package com.xgl.config;

import com.config.CustomConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/*
 *CustomClientConfig
 *
 *@author 87990
 *@email
 *@date 2019/10/6
 */
@RibbonClient(name = "user-service-provider", configuration = CustomConfiguration.class)
public class CustomClientConfig {



}

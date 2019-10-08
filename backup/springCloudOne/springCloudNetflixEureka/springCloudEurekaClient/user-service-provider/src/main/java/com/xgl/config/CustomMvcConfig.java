package com.xgl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
import com.xgl.message.JsonUserHttpMessageConverter;
/*
 *CustomMvcConfig
 *
 *@author 87990
 *@email
 *@date 2019/9/28
 */
//@Configuration
//@Order(0)
public class CustomMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new JsonUserHttpMessageConverter());
    }

}

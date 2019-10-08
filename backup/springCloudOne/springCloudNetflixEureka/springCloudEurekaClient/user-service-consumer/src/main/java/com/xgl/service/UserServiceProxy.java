package com.xgl.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.xgl.domain.User;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
 *UserServiceProxy
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@Service
public class UserServiceProxy implements UserService {
    public static final String CLIENT_NAME = "user-service-provider";
    public static final String PROVIDER_SERVER_URL_PREFIX = "http://"+CLIENT_NAME;

    /**
     * 通过Rest Api 代理到服务提供者
     */
    private final RestTemplate restTemplate;

    public UserServiceProxy(RestTemplate restTemplate, HttpServletRequest request) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean save(User user) {
        restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
        User returnValue =
                restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/save", user, User.class);
        return returnValue != null;
    }

    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list", Collection.class);
    }
}

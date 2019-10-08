package com.xgl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/*
 *EchoEnvController
 *
 *@author 87990
 *@email
 *@date 2019/9/24
 */
@RestController
public class EchoEnvController {
    private final Environment environment;

    @Autowired
    public EchoEnvController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/env/{name}")
    public String getEnvironment(@PathVariable("name") String name) {
        return environment.getProperty(name);
    }
}

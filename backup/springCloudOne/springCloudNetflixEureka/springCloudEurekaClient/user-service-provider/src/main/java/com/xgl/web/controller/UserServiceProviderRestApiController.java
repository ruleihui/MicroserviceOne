package com.xgl.web.controller;

import com.xgl.domain.User;
import com.xgl.service.UserService;
import com.xgl.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Collection;

/*
 *{@link UserService}提供方restApi{@link RestController}
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@RestController
public class UserServiceProviderRestApiController {
    private final UserService userService;

    @Autowired
    public UserServiceProviderRestApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
        if (userService.save(user))
            return user;
        else
            return null;
    }

    @GetMapping("/user/list")
    public Collection<User> list() {
        return userService.findAll();
    }

}

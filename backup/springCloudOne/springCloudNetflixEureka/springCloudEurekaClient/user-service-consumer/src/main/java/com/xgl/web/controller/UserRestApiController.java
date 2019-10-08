package com.xgl.web.controller;

import com.xgl.domain.User;
import com.xgl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/*
 *UserController
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@RestController
public class UserRestApiController {
    private final UserService userService;

    @Autowired
    public UserRestApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestParam String name) {
        User user = new User(-1l,name);
        if (userService.save(user))
            return user;
        else
            return null;
    }

    @GetMapping("/user/list")
    public Collection<User> list() {
        return userService.findAll();
    }

//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Annotation annotation = UserRestApiController.class.getDeclaredMethods()[1].getAnnotations()[0];
//        Class<? extends Annotation> aClass = annotation.annotationType();
//        Method value = aClass.getDeclaredMethod("value");
//        System.out.println(((String[]) value.invoke(annotation))[0]);
//    }
}

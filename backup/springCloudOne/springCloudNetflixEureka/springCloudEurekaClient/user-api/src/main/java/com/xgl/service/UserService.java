package com.xgl.service;

import com.xgl.domain.User;

import java.util.Collection;

/*
 *UserService
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
public interface UserService {

    public boolean save(User user);

    Collection<User> findAll();
}

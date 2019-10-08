package com.xgl.service;

import com.xgl.domain.User;
import com.xgl.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

/*
 *UserServiceImpl
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}

package com.xgl.repository;

import com.xgl.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/*
 *UserRepository
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@Repository
public class UserRepository {
    private ConcurrentMap<Long, User> userRepository=new ConcurrentHashMap<>();
    private static final AtomicLong isGenerator=new AtomicLong();
    public Collection<User> findAll() {
      return   userRepository.values();
    }

    public boolean save(User user) {
        long id = isGenerator.getAndIncrement();
        user.setId(id);
        return userRepository.putIfAbsent(id,user)!=null;
    }
}

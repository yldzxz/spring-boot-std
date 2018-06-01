package com.hkz.service;

import com.hkz.dao.UserRepository;
import com.hkz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huangkz on 2018/5/31.
 */
@Service
@EnableCaching
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    //@Cacheable(value = "user",key = "#user.id")
    public User findUserById(Integer id) {
        System.out.println("调用方法，不使用缓存");
        return userRepository.findById(id);
    }

    @CachePut(value = "user", key = "#user.id")
    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "user")
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}

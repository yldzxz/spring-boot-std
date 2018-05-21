package com.hkz.service;

import com.hkz.dao.UserRepository;
import com.hkz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by huangkz on 2018/5/21.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUser(Integer id) {
        User user  = userRepository.findById(id);
        return user;
    }
}

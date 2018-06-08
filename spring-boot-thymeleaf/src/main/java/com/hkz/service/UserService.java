package com.hkz.service;

import com.hkz.domain.User;

import java.util.List;

/**
 * Created by huangkz on 2018/6/8.
 */

public interface UserService {

    int  deleteById(int id);

    User findUserById(long id);

    User save(User user);

    List<User> findAll();

}

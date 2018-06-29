package com.hkz.sim.service;

import com.hkz.sim.domain.User;

import java.util.List;

/**
 * Created by huangkz on 2018/6/25.
 */
public interface UserService {

    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);
}

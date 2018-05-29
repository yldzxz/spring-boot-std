package com.hkz.service;

import com.hkz.domain.UserEhcache;

/**
 * Created by huangkz on 2018/5/29.
 */

public interface UserService {

    UserEhcache findUserById(int id);

    UserEhcache updateUser(UserEhcache user);

    boolean deleteUserById(int id);
}

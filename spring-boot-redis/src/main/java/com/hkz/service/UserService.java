package com.hkz.service;

import com.hkz.dao.UserRepository;
import com.hkz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by huangkz on 2018/5/21.
 */

public interface UserService {

    User findUserById(Integer id);

    User addUser(User user);

    void deleteUser(int  id);

}

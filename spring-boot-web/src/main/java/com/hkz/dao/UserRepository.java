package com.hkz.dao;

import com.hkz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huangkz on 2018/5/18.
 */

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);


}

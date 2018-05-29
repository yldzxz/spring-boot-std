package com.hkz.dao;

import com.hkz.domain.UserEhcache;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huangkz on 2018/5/29.
 */

public interface UserRepository extends JpaRepository<UserEhcache, Integer>{
    UserEhcache findByUsername(String username);
}

package com.hkz.redis;

import com.hkz.domain.User;
import com.hkz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by huangkz on 2018/5/21.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Autowired
    private UserService userService;

    public User getUserById(@PathVariable Integer id) {
        return userService.findUser(id);
    }
}

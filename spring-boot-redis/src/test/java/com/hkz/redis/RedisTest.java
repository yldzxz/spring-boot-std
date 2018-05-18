package com.hkz.redis;

import com.hkz.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangkz on 2018/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void test(){
        User user = new User();
        user.setUsername("hkz");
        user.setPassword("kkk");
        redisService.add("user:"+user.getUsername(),user,10L);
        List<User> list = new ArrayList<User>();
        list.add(user);
        redisService.add("list",list,10L);
        User user1 = redisService.get("user:"+user.getUsername());
        Assert.notNull(user1, "user is null");
        List<User> list2 = redisService.getUserList("list");
        Assert.notNull(list2, "list is null");
    }
}

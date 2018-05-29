package com.hkz.service;

import com.hkz.dao.UserRepository;
import com.hkz.domain.UserEhcache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by huangkz on 2018/5/29.
 */
@Service
@CacheConfig(cacheNames = "roncooCache")
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;

    /*@Cacheable
    * key属性是用来指定Spring缓存方法的返回结果时对应的key的,
    * Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，
    * 而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中
    */
    @Override
    @Cacheable(key = "#p0")
    public UserEhcache findUserById(int id) {
        System.out.println("没有缓存，直接读取数据库，findUserById :"+id);
        return userRepository.getOne(id);
    }
    /*
    * @CachePut也可以声明一个方法支持缓存功能。与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
    * 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    * */
    @CachePut(key = "#p0")
    @Override
    public UserEhcache updateUser(UserEhcache user) {
        System.out.println("没有缓存，直接读取数据库，updateUser:"+user);
        UserEhcache userEhcache = userRepository.save(user);
        return userEhcache;
    }

    /*
    *  @CacheEvict是用来标注在需要清除缓存元素的方法或类上的。
    *  当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。
    *  属性：
    *  allEntries是boolean类型，表示是否需要清除缓存中的所有元素。
    *  beforeInvocation属性，清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。
    * */
    @CacheEvict(key = "#p0")
    @Override
    public boolean deleteUserById(int id) {
        System.out.println("没有缓存，直接读取数据库，deleteUserById:"+id);
        userRepository.deleteById(id);
        return true;
    }
}

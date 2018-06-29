package com.hkz.sim.mapper;

import com.hkz.sim.domain.Sex;
import com.hkz.sim.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huangkz on 2018/6/22.
 */
@Repository
public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "userSex",column = "user_sex",javaType = Sex.class)
    })
    List<User> getAll();

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "userSex",column = "user_sex",javaType = Sex.class)
    })
    User getOne(long id);

    @Insert("inser into user(username,password,sex) values(#{username},#{password},#{sex}) ")
    int insert(User user);

    @Update("update user set username = #{username},password=#{password},sex=#{sex} where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    int delete(long id);
}

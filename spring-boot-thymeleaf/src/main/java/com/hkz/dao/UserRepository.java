package com.hkz.dao;

import com.hkz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by huangkz on 2018/5/18.
 */

public interface UserRepository extends JpaRepository<User, Long>{

    @Query(value = "select a.id,a.username,a.password from User a where a.id = ?1",nativeQuery = true)
    User findUserById(long id);

    @Modifying
    @Query("delete from User where id = :id")
    int  deleteById(@Param("id") int id);
}

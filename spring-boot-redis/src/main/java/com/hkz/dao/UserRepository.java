package com.hkz.dao;

import com.hkz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by huangkz on 2018/5/18.
 */

public interface UserRepository extends JpaRepository<User, Long>{

    User findById(Integer id);

    @Query("delete from User where id = :id")
    boolean deleteById(int id);
}

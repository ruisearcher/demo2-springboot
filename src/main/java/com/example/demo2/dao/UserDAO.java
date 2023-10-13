package com.example.demo2.dao;

import com.example.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    //@Query("select * from User u where u.userId = ?1 LIMIT 1")
    //User findByUserId(int userId);
    //User findByUserName(String userName);

}
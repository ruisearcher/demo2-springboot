package com.example.demo2.dao;

import com.example.demo2.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/10/13 10:42
 */
@Mapper
public interface UserMapper {

    int findAll();

    User findByUserName(String userName);
}

package com.example.demo2.service;

import com.example.demo2.entity.User;
import com.example.demo2.model.UserDto;

import java.util.List;

public interface UserService {

    void delete(List<Integer> ids);

    String login(UserDto userDto);

    String create(User entity);
}

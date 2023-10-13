package com.example.demo2.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.jwt.JWTUtil;
import com.example.demo2.dao.UserDAO;
import com.example.demo2.dao.UserMapper;
import com.example.demo2.entity.User;
import com.example.demo2.exception.JsonResult;
import com.example.demo2.model.UserDto;
import com.example.demo2.service.UserService;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * ArticleService实现类
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Resource
    private UserMapper userMapper;

    @Resource
    Cache<String, Object> cache;

    String salt = "xx_salt";

    @Override
    public void delete(List<Integer> ids) {
        userDAO.deleteAllByIdInBatch(ids);
    }

    @Override
    public String login(UserDto dto) {

        User login = userMapper.findByUserName(dto.getUserName());
        if (login.getPassword().equals(dto.getPassword())) {
            HashMap<String, Object> payload = new HashMap<>();
            BeanUtil.beanToMap(dto, payload, false, false);
            payload.put("time", System.currentTimeMillis());
            String token = JWTUtil.createToken(payload, salt.getBytes());
            //tokenMap.put(token, dto);
            cache.put(token, dto);
            return JsonResult.of("登录成功",new HashMap<String,String>(){{
                put("token", token);
            }}).toJson();
        }
        throw new RuntimeException("账户密码不匹配");
    }

    @Override
    public String create(User entity) {
        User login = userMapper.findByUserName(entity.getUserName());
        if (login != null) {
            return JsonResult.err("账号已存在").toJson();
        }
        User save = userDAO.save(entity);
        if (ObjUtil.isNotNull(save)) {
            return JsonResult.of("创建成功", entity).toJson();
        } else {
            return JsonResult.err("创建失败").toJson();
        }
    }
}

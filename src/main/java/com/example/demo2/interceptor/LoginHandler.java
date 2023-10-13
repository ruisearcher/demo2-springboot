package com.example.demo2.interceptor;

import cn.hutool.core.util.ObjUtil;
import com.example.demo2.config.WebMvcConfiguration;
import com.example.demo2.controller.UserController;
import com.example.demo2.model.UserDto;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册到WebMvcConfiguration
 * @see WebMvcConfiguration#addInterceptors
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/6/7 10:19
 */
public class LoginHandler implements HandlerInterceptor {

    //@Autowired
    //private UserController u;
    @Resource
    Cache<String, Object> cache;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //Object o = u.tokenMap.get(token);
        Object o = cache.getIfPresent(token);
        if (ObjUtil.isEmpty(o) || !(o instanceof UserDto)) {
            throw new RuntimeException("没有登录");
            //return false;
        }else {
            //已经登录
            System.out.println("已经登录");
            return true;
        }
    }

}


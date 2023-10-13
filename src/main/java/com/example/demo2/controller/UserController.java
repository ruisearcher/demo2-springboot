package com.example.demo2.controller;

import com.example.demo2.entity.User;
import com.example.demo2.exception.JsonResult;
import com.example.demo2.model.UserDto;
import com.example.demo2.service.UserService;
import com.example.demo2.annotation.CostTime;
import com.github.benmanes.caffeine.cache.Cache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/5/26 13:37
 */
@RestController
@RequestMapping("/demo/user")
@Api(tags = "账户管理")
public class UserController {

    @Resource
    UserService loginService;

    @CostTime
    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestBody UserDto dto) {
        return loginService.login(dto);
    }

    @PostMapping("/create")
    @ApiOperation("创建账号")
    public String create(@RequestBody User entity) {
        return loginService.create(entity);
    }

    @PostMapping("/delete")
    @ApiOperation("删除账号")
    public String delete(@RequestBody List<Integer> ids) {
        loginService.delete(ids);
        return JsonResult.of("删除成功").toJson();
    }
}


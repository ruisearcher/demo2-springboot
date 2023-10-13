package com.example.demo2.controller;

import cn.hutool.core.util.ObjUtil;
import com.example.demo2.exception.JsonResult;
import com.example.demo2.model.UserDto;
import com.github.benmanes.caffeine.cache.Cache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/5/26 16:32
 */
@RestController()
@RequestMapping("/demo/doSth")
@Api(tags = "doSth管理")
public class doSthController {

    @Resource
    Cache<String, Object> cache;

    @PostMapping("/greet")
    @ApiOperation("打招呼")
    public String greet(HttpServletRequest request) {
        String token = request.getHeader("token");
        Object o = cache.getIfPresent(token);
        if (ObjUtil.isEmpty(o) || !(o instanceof UserDto)) {
            throw new RuntimeException("账户错错错");
        }
        String userName = ((UserDto) o).getUserName();
        //payload.
        return JsonResult.of("hello, " + userName).toJson();
    }

    @PostMapping("/test_exception1")
    @ApiOperation("test_exception1")
    public String testException1() throws MissingServletRequestParameterException {
        throw new MissingServletRequestParameterException("a", "s");
    }



    @PostMapping("/test_exception2")
    @ApiOperation("test_exception2")
    public String testException2() throws RuntimeException {
        throw new RuntimeException("asadsd");
    }


}

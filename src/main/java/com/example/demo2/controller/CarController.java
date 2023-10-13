package com.example.demo2.controller;

import com.example.demo2.entity.Car;
import com.example.demo2.exception.JsonResult;
import com.example.demo2.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/6/7 11:17
 */
@RestController
@RequestMapping("/demo/car")
@Api(tags = "汽车管理")
public class CarController {
    @Resource
    CarService carService;

    @PostMapping("/add")
    @ApiOperation("添加汽车")
    public String add(@RequestBody Car car) {
        carService.add(car);
        return new JsonResult<>().toJson();
    }

    @PostMapping("/findAll")
    @ApiOperation("添加汽车")
    public String findAll() {
        List<Car> data = carService.findAll();
        return new JsonResult<>().setData(data).toJson();
    }
}

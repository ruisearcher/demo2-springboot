package com.example.demo2.service.impl;

import cn.hutool.json.JSONUtil;
import com.example.demo2.dao.CarDAO;
import com.example.demo2.entity.Car;
import com.example.demo2.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/6/7 11:14
 */
@Service
public class CarServiceImpl implements CarService {
    @Resource
    CarDAO carDAO;

    @Override
    public int add(Car car) {
        System.out.println("car = " + JSONUtil.toJsonStr(car));
        Car save = carDAO.save(car);
        return 1;
    }

    @Override
    public int delete(Car car) {
        carDAO.delete(car);
        return 1;
    }

    @Override
    public int edit(Car car) {
        carDAO.save(car);
        return 1;
    }

    @Override
    public List<Car> findAll() {
        List<Car> all = carDAO.findAll();
        return all;
    }
}

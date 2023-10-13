package com.example.demo2.service;

import com.example.demo2.entity.Car;

import java.util.List;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/6/7 11:12
 */
public interface CarService {
    int add(Car car);
    int delete(Car car);
    int edit(Car car);
    List<Car> findAll();
}

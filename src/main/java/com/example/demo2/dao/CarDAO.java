package com.example.demo2.dao;

import com.example.demo2.entity.Car;
import com.example.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDAO extends JpaRepository<Car, Integer> {

}
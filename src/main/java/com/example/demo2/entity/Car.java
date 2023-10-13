package com.example.demo2.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/5/26 17:09
 */
@Data
@Entity
@Table(name = "t_car")
public class Car {
    @Id
    @GenericGenerator(name = "Car-uuid", strategy = "increment")
    @GeneratedValue(generator = "Car-uuid")
    private long id;
    private String name;
    private String owner;
    private String carClass;
}

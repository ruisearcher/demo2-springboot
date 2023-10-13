package com.example.demo2.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GenericGenerator(name = "Car-uuid", strategy = "increment")
    @GeneratedValue(generator = "Car-uuid")
    private int userId;
    private String userName;
    private String password;

}
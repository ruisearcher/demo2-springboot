package com.example.demo2.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/5/26 13:46
 */
@Data
@Accessors(chain = true)
public class UserDto {
    private int userId;
    private String userName;
    private String password;
}

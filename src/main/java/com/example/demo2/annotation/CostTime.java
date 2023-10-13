package com.example.demo2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/10/13 9:44
 */

@Target( ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CostTime {

}

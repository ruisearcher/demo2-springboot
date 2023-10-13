package com.example.demo2.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/9/22 10:15
 */
public class Test22222 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Person person = new Person("zs", 18);
        list.add(person);
        list.add(person);
        person.setAge(19);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
class Person {
    String name;
    Integer age;
}

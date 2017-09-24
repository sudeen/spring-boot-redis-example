package com.sudin.redis.springbootredisexample.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable{

    private String id;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}

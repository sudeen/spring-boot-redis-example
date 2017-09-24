package com.sudin.redis.springbootredisexample.controllers;

import com.sudin.redis.springbootredisexample.model.User;
import com.sudin.redis.springbootredisexample.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/rest/user")
public class UserResourceController {


    private UserRepository userRepository;

    public UserResourceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{firstName}")
    public User add(@PathVariable("firstName") final String firstName,
                    @PathVariable("id") final String id) {
        userRepository.save(new User(id,firstName,"Ranjit"));
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}/{firstName}")
    public User update(@PathVariable("firstName") final String firstName,
                    @PathVariable("id") final String id) {
        userRepository.update(new User(id,"Sudin","Ranjitkar"));
        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String,User> all() {
        return userRepository.findAll();
    }

    @GetMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") final String id) {
        userRepository.delete(id);
        return all();
    }

}

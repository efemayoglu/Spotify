package com.medipol.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedipolUserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/users")
    public List<User> findUsers(){

        return userService.findUsers();
    }

    @RequestMapping(path = "/addUser")
    public List<User> addUser(@RequestParam String name, @RequestParam String surName){

        userService.addUser(name, surName);

        return userService.findUsers();
    }

    @RequestMapping(path = "/usersByName")
    public List<User> findUsersByName(@RequestParam String name){

        System.out.println("disardan gonderilen deger : " + name);

        return userService.findUsersByName(name);
    }

}

package com.medipol.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserWebController {

    @Autowired UserService userService;

    @RequestMapping("/wusers")
    public String users(Model model){

        final List<User> users = userService.findUsers();
        model.addAttribute("user", users);
        model.addAttribute("name", "hebele");

        return "users";
    }
}

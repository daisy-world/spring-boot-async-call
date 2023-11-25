package com.easy2excel.userservice.controller;

import com.easy2excel.userservice.entity.User;
import com.easy2excel.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
 @Autowired
    UserService userService;
 @PostMapping("/register")
 public String resgisterUser(@RequestBody User user) {

     //synchronous call
     User dbUser = userService.saveUser(user);
     //asynchronous call
     userService.sendEmail(user);
     userService.sendNotification(user);
     return "user registered successfully :" + dbUser.getId();
 }
}

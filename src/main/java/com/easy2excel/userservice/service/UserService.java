package com.easy2excel.userservice.service;

import com.easy2excel.userservice.entity.User;
import com.easy2excel.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User saveUser(User user){
        System.out.println("inside saveUser() method :" + Thread.currentThread().getName());
        return userRepository.save(user);
    }

    @Async
    public void sendEmail(User user)  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println("email sent successfully :" + Thread.currentThread().getName());

    }
    @Async
    public void sendNotification(User user) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("notification sent successfully :" + Thread.currentThread().getName());


    }
}

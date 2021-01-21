package com.yjy.springlearn.demo.service;

import com.yjy.springlearn.demo.annotation.AssertOK;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


@Service
public class Userservice {
    @AssertOK
    public String getUserById(Integer id){
        System.out.println("get user by id");
        int a = 1/id;
        return "user";
    }
    public void deleteUserById(Integer id){
        System.out.println("delete by id");
    }
}

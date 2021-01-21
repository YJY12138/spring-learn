package com.yjy.springlearn.demo.entity;

import org.springframework.stereotype.Component;


public class User {
    public User(){
        System.out.println("调用了USER的无参构造器");
    }
    public  void talk(){
        System.out.println("USER 被使用");
    }
    public void init(){
        System.out.println("调用了init方法初始化USER");
    }
    public void destory(){
        System.out.println("调用了Destory销毁User");
    }
}

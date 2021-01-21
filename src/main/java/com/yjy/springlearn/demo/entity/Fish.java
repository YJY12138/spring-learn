package com.yjy.springlearn.demo.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Fish {
    public Fish() {
        System.out.println("调用无参构造器创建Fish");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化Fish");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁Fish");
    }
}

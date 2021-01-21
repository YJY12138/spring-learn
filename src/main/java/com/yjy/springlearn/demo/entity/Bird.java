package com.yjy.springlearn.demo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bird implements InitializingBean, DisposableBean {
    Logger logger = LoggerFactory.getLogger(Bird.class);
    public Bird(){
        logger.trace("调用了无参构造器创建Bird");
        System.out.println("调用了无参构造器创建Bird");
    }
    @Override
    public void afterPropertiesSet(){
        System.out.println("调用了afterPropertiesSet");
        logger.trace("初始化 Bird");
    }

    @Override
    public void destroy() {
        logger.trace( "销毁了Bird");
        System.out.println("销毁了Bird");
    }
}

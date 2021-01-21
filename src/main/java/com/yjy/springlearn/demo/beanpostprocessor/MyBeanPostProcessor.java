package com.yjy.springlearn.demo.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException{
        System.out.println(beanName+"初始化之前调用了postProcessBeforeInitialization方法");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException{
        System.out.println(beanName+"初始化之后调用了postProcessAfterInitialization方法");
        return bean;
    }

}

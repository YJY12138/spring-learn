package com.yjy.springlearn.demo.beanpostprocessor;


import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Constructor;


public class MySmartBeanPostProcessor  implements SmartInstantiationAwareBeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName)throws BeansException{
        if("user".equals(beanName)){
            System.out.println(beanName+" 初始化之前");
        }
        return bean;
        }

    @Override
    public Object postProcessAfterInitialization(Object bean ,String beanName)throws BeansException{
        if("user".equals(beanName)) {
            System.out.println(beanName + " 初始化之后");
        }
        return bean;
    }
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass , String beanName)throws BeansException{

        if("user".equals(beanName)) {
            System.out.println(beanName+" 实例化之前");
        }
        return null;
    }
    @Override
    public boolean postProcessAfterInstantiation(Object bean ,String beanName)throws BeansException{
        if("user".equals(beanName)) {
            System.out.println(beanName+" 实例化之后");
        }
        return true;
    }
    @Override
    @Nullable
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if("user".equals(beanName)) {
            System.out.println(beanName+" 变量处理");
        }

        return null;
    }

    @Override
    @Nullable
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {

        if("A".equals(beanName)|| "B".equals(beanName)) {
            System.out.println("预测"+beanName+"的类型");
        }

        return null;
    }

    @Override
    @Nullable
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)
            throws BeansException {
        if("user".equals(beanName)) {
            System.out.println(beanName+"选择构造器");
        }

        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if("A".equals(beanName)|| "B".equals(beanName)) {
            System.out.println(beanName+"提前暴露引用");
        }
        return bean;
    }
}

package com.yjy.springlearn.demo.config;

import com.yjy.springlearn.demo.beanpostprocessor.MySmartBeanPostProcessor;
import com.yjy.springlearn.demo.entity.Bird;
import com.yjy.springlearn.demo.entity.Fish;
import com.yjy.springlearn.demo.entity.User;
import com.yjy.springlearn.demo.factorybean.UserFactoryBean;
import org.springframework.context.annotation.*;

@Configuration
public class BeanConfig {

    @Lazy
    @Bean(initMethod = "init",destroyMethod = "destory")
    public User user(){
        return new User();
    }
    @Bean
    public UserFactoryBean userFactoryBean() {
        return new UserFactoryBean();
    }
    @Bean
    public Bird bird(){
        return new Bird();
    }
    @Bean
    public Fish fish(){
        return new Fish();
    }
//    @Bean
//    public MyBeanPostProcessor myBeanPostProcessor(){
//        return new MyBeanPostProcessor();
//    }
    @Bean
    public MySmartBeanPostProcessor mySmartBeanPostProcessor(){
        return new MySmartBeanPostProcessor();
    }
}

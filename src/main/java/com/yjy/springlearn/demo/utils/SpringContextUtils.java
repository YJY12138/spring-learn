package com.yjy.springlearn.demo.utils;

import com.yjy.springlearn.demo.SpringEventListenerTest.MailSender;
import com.yjy.springlearn.demo.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SpringContextUtils {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        if (null == SpringContextUtils.applicationContext) {
            SpringContextUtils.applicationContext = applicationContext;
//            List<String> BeanList= new LinkedList<String>(Arrays.asList(applicationContext.getBeanDefinitionNames().clone()));
//            Iterator<String> it= BeanList.listIterator();
//            while(it.hasNext()){
//                System.out.println(it.next());
//            }
            //遍历数组，和上面功能相同
            //  Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
            applicationContext.getBean(User.class).talk();
            Object user = applicationContext.getBean("userFactoryBean");
            System.out.println(user.getClass());
//
            MailSender sender = (MailSender) applicationContext.getBean("mailSender");
            sender.sendMail("北京");
        }
    }

}

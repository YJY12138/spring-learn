package com.yjy.springlearn.demo.SpringEventListenerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("mailSender")
public class MailSender {
    @Autowired
    private ApplicationContext applicationContext;

    public void sendMail(String to){
        System.out.println("MailSender开始发送邮件");
        MailSendEvent event = new MailSendEvent(applicationContext,to);
        applicationContext.publishEvent(event);
    }
}
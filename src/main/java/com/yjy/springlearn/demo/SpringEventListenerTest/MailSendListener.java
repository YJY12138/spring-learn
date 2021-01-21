package com.yjy.springlearn.demo.SpringEventListenerTest;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MailSendListener implements ApplicationListener<MailSendEvent>{
    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        MailSendEvent event = mailSendEvent;
        System.out.println("MailSender向"+ event.getTo()+ "发送了邮件");
    }
}
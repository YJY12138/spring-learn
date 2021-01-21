package com.yjy.springlearn.demo.Listener;

import com.yjy.springlearn.demo.utils.SpringContextUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class MainBusiListeners implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        SpringContextUtils.setApplicationContext(event.getApplicationContext());
    }
}

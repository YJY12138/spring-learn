package com.yjy.springlearn.demo.config;


import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalConfig {
    @InitBinder("b")
    public void init_a(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }

    @InitBinder("a")
    public void init_b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }
}

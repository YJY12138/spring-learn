package com.yjy.springlearn.demo;

import com.yjy.springlearn.demo.Listener.MainBusiListeners;
import com.yjy.springlearn.demo.filter.MyTypeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

/**
 * @author youjy
 */
@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
//     SpringApplication.run(SpringLearnApplication.class, args);
        SpringApplication sa = new SpringApplication(SpringLearnApplication.class);
        sa.addListeners(new MainBusiListeners());
        sa.run(args);
    }

}

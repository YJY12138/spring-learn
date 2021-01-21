package com.yjy.springlearn.demo;

import com.yjy.springlearn.demo.entity.Bird;
import com.yjy.springlearn.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringLearnApplication.class)
public class SpringLearnApplicationTests {

    @Autowired
    User user;
    @Autowired
    Bird bird;
    @Test
   public void contextLoads() {
        System.out.println("执行测试方法");
    }

}

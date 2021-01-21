package com.yjy.springlearn.demo.annotation;




import java.lang.annotation.*;

/**
 * @author youjy
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AssertOK {

    String isLogin() default "false";

}

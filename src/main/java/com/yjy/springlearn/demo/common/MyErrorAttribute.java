package com.yjy.springlearn.demo.common;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author youjy
 */
@Component
public class MyErrorAttribute  extends DefaultErrorAttributes {
    @Override
    public Map<String,Object> getErrorAttributes(WebRequest webRequest,boolean includeStackTrace){

        //获取spring boot默认提供的错误信息
        Map<String,Object> errorAttributes = super.getErrorAttributes(webRequest,includeStackTrace);
        errorAttributes.put("custommsg","出错啦！");
        return errorAttributes;
    }

}

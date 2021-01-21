package com.yjy.springlearn.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youjy
 */
@Configuration
public class MyFastJsonConfig {
    @Bean
   public HttpMessageConverters  fastJsonHttpMessageConverter(){
            FastJsonHttpMessageConverter  fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
            FastJsonConfig fastJsonConfign = new FastJsonConfig();
            fastJsonConfign.setSerializerFeatures(
                    SerializerFeature.PrettyFormat,
                    SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty
            );

            List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
            fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

            fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfign);

            return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }
}

package com.starnet.musicmanager.config;

import com.starnet.musicmanager.common.AuthInterceptor;
import com.starnet.musicmanager.common.JacksonObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author:
 * @date:
 * @description SpringMVC配置类
 */
@Configuration
public class SpringMVCConfig extends WebMvcConfigurationSupport {

    /**
     * 拓展MVC框架的消息转换器
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //设置对象转换器（为消息转换器对象设置自定义的JSON转换器）
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //将创建的转换器放在mvc的转换器列表中，并且为了保证我们自定义的消息转换器能生效，我们得要设置转换器在最前位(即index=0)。
        converters.add(0, messageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(authInterceptor()).
                addPathPatterns("/**");
    }
    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }

}

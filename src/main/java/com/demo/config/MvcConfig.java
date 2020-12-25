package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver bean =new InternalResourceViewResolver();
        bean.setPrefix("WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

}

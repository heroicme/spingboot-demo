package com.heroic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Bao
 * @Description:
 * @Date 2018/11/25
 */
@Configuration
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //就是和写在@controller 方法一样 返回一个字符串 视图解析去找对应的静态资源
        registry.addViewController("/login").setViewName("login");



    }
}

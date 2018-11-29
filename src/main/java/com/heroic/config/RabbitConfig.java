package com.heroic.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bao
 * @Description:
 * @Date 2018/11/27
 */
@Configuration
public class RabbitConfig {
@Bean
    public MessageConverter ms(){
        return new Jackson2JsonMessageConverter();
    }



}

package com.heroic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.heroic.mapper")//扫描mapper接口
@EnableCaching//开启缓存
@EnableRabbit//开启监听信息队列
@EnableAsync//开启异步调用
//@EnableScheduling//开启定时任务
public class DemoApplication  /*extends SpringBootServletInitializer*/ {

//配置打包
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

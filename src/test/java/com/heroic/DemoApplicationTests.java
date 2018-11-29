package com.heroic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    /*@Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;*/

    @Autowired
    private RabbitTemplate rabbitTemplate;//发送信息的工具类

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void testAdmin() {
        amqpAdmin.declareExchange(new DirectExchange("Admin.direct"));//创建交换器
        amqpAdmin.declareQueue(new Queue("admin.queue", true));//创建队列
        amqpAdmin.declareBinding(new Binding("admin.queue",//设置绑定
                DestinationType.QUEUE, "Admin.direct", "admin.queue", null));


    }


    @Test
    public void testRedis() throws Exception {


        Map msg = new HashMap();
        msg.put("k1", "测试1");
        msg.put("k2", new Date());
        //自定义序列化规则 转化成json
        rabbitTemplate.convertAndSend("Admin.direct", "admin.queue", msg);

       /* Employee emp = employeeMapper.selectByPrimaryKey(1);

        ObjectMapper mapper = new ObjectMapper();

        String emp1 = mapper.writeValueAsString(emp);//对象转成json
        System.out.println(emp1);
        redisTemplate.opsForValue().set("emp1", emp1);
        String stoemp = (String) redisTemplate.opsForValue().get("emp1");
        Employee e = mapper.readValue(stoemp, Employee.class);//json转对象
        System.out.println(e.getClass());
        System.out.println(e);


    }*/
    }

    @Test
    public void getMsg() {

        Object o = rabbitTemplate.receiveAndConvert("admin.queue");
        System.out.println(o.getClass());
        System.out.println(o);


    }
}

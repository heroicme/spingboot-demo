package com.heroic.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Bao
 * @Description:
 * @Date 2018/11/27
 */

@Service
public class TestAsync {


@Async
    public void task(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("处理数据");
    }
}

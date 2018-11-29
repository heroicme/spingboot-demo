package com.heroic.controller;

import com.heroic.service.impl.TestAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bao
 * @Description:
 * @Date 2018/11/27
 */
@RestController
public class AsynController {
@Autowired
private TestAsync TestAsync;

@RequestMapping("/hi")
    public  String say(){
    TestAsync.task();
        return "helo";
    }
}

package com.springboot.mq.controller;

import com.springboot.mq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZQZ
 * @Description:
 * @ClassName: TestController
 * @Date: Created in 15:09 2022/5/27
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ProducerService producerService;

    @GetMapping("sendSmsMsg")
    public String sendSmsMsg(@RequestParam("msg") String msg) {
        producerService.sendSms(msg);
        return "END";
    }
}

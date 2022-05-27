package com.springboot.mq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ZQZ
 * @Description:
 * @ClassName: SmsListener
 * @Date: Created in 14:59 2022/5/27
 */
@Component
@RabbitListener(queues = {"ZQZ_SMS_QUEUE"})
@Slf4j
public class SmsListener {

    @RabbitHandler
    public void smsMessage(String msg) {
        log.info("【sms】接收到了消息:{}", msg);
    }


}

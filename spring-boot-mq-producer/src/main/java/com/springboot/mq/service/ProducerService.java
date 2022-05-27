package com.springboot.mq.service;

import com.springboot.mq.constants.ConfigConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ZQZ
 * @Description:
 * @ClassName: ProducerService
 * @Date: Created in 15:04 2022/5/27
 */
@Service
@Slf4j
public class ProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSms(String msg){
        log.info("【sms】发送消息:{}", msg);
        rabbitTemplate.convertAndSend(ConfigConstant.TOPIC_EXCHANGE_NAME, ConfigConstant.ROUTE_KEY, msg);
    }
}

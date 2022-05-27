package com.springboot.mq.config;

import com.springboot.mq.constants.ConfigConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZQZ
 * @Description:
 * @ClassName: RabbitMqConfig
 * @Date: Created in 14:33 2022/5/27
 */
@Configuration
public class RabbitMqConfig {


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(ConfigConstant.TOPIC_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(ConfigConstant.QUEUE_NAME, true);
    }


    @Bean
    public Binding smsBinding() {
        return BindingBuilder.bind(smsQueue()).to(topicExchange()).with(ConfigConstant.ROUTE_KEY);
    }


}

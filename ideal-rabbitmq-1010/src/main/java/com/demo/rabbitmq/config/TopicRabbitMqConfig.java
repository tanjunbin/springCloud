package com.demo.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMqConfig {

    private static final String SMS_QUEUE = "topic.sms";

    private static final String EMAIL_QUEUE = "topic.email";

    public static final String CONFIG_EXCHANGE = "config_exchange";

    // 1.定义短信和邮件队列
    @Bean
    public Queue configSmsQueue(){
        return new Queue(SMS_QUEUE,true);
    }
    @Bean
    public Queue configEmailQueue(){
        return new Queue(EMAIL_QUEUE,true);
    }

    // 2.定义一个交换机
    @Bean
    public TopicExchange configExchange(){
        return new TopicExchange(CONFIG_EXCHANGE);
    }

    // 3.将队列绑定到交换机上
    @Bean
    Binding bindingExchangeSms(Queue configSmsQueue,TopicExchange configExchange){
        return BindingBuilder.bind(configSmsQueue).to(configExchange).with("topic.sms");
    }

    @Bean
    Binding bindingExchangeEmail(Queue configEmailQueue,TopicExchange configExchange){
        return BindingBuilder.bind(configEmailQueue).to(configExchange).with("topic.email");
    }
}

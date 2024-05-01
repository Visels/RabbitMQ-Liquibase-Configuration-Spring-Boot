package com.example.liqrab.async;

import com.example.liqrab.MQConfig.MQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Message message){
     log.info("Message received -> " + message.toString());
    }
}

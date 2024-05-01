package com.example.liqrab.message;

import com.example.liqrab.MQConfig.MQConfig;
import com.example.liqrab.async.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publicMessage(@RequestBody  Message message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(LocalDate.now());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);

        return "message published";
    }

}

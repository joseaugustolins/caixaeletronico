package com.test.caixaeletronico.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
public class AporteSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String aporte){
        rabbitTemplate.convertAndSend("AporteQueue", aporte);
    }
}

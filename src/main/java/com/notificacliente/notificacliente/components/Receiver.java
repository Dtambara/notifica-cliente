package com.notificacliente.notificacliente.components;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    EnviaEmail mailer;

    @Bean
    Queue queue() {
        return new Queue("ClienteQ", false);
    }

    @RabbitListener(queues = "ClienteQ")
    public void processaMensagem(String email) {
        System.out.println(email);
        mailer.enviaEmail(email);
    }
}

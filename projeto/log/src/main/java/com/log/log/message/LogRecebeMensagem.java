package com.log.log.message;

import com.log.log.model.Log;
import com.log.log.service.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class LogRecebeMensagem {
    @Autowired
    private LogService logService;

    @RabbitListener(queues = {"${instituto.rabbitmq.queue}"})
    public void receiveInstituto(@Payload Log user) {
        logService.createLogInstituicao(user);
    }

    @RabbitListener(queues = {"${jovem.rabbitmq.queue}"})
    public void receiveJovem(@Payload Log quadro) {
        logService.createLogJovem(quadro);
    }

    @RabbitListener(queues = {"${apoiador.rabbitmq.queue}"})
    public void receiveApoiador(@Payload Log card) {
        logService.createLogApoiador(card);
    }

    @RabbitListener(queues = {"${curso.rabbitmq.queue}"})
    public void receiveCurso(@Payload Log card) {
        logService.createLogCurso(card);
    }
}

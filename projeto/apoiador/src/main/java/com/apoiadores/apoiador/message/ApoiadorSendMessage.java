package com.apoiadores.apoiador.message;

import com.apoiadores.apoiador.model.Action;
import com.apoiadores.apoiador.model.Apoiador;
import com.apoiadores.apoiador.model.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApoiadorSendMessage {
    @Value("${apoiador.rabbitmq.exchange}")
    String exchange;

    @Value("${apoiador.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Apoiador apoiador, Action action) {
        Log log = new Log();
        log.setAction(action);
        log.setDataLog(log.getDataLog());
        log.setApoiadorNome(apoiador.getNome());
        log.setApoiadorTelefone(apoiador.getTelefone());
        log.setApoiadorCpf(apoiador.getCpf());
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}

package com.instituicao.instituto.message;

import com.instituicao.instituto.model.Action;
import com.instituicao.instituto.model.Instituicao;
import com.instituicao.instituto.model.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InstitutoSendMessage {
    @Value("${instituto.rabbitmq.exchange}")
    String exchange;

    @Value("${instituto.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Instituicao instituicao, Action action) {
        Log log = new Log();
        log.setAction(action);
        log.setDataLog(log.getDataLog());
        log.setNomeInstituicao(instituicao.getNome());
        log.setEnderecoInstituicao(instituicao.getEndereco());
        log.setCnpjInstituicao(instituicao.getCnpj());
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}

package com.jovens.jovem.message;

import com.jovens.jovem.model.Action;
import com.jovens.jovem.model.Jovem;
import com.jovens.jovem.model.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JovemSendMessage {
    @Value("${jovem.rabbitmq.exchange}")
    String exchange;

    @Value("${jovem.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Jovem jovem, Action action) {
        Log log = new Log();
        log.setAction(action);
        log.setDataLog(log.getDataLog());
        log.setJovemNome(jovem.getNome());
        log.setJovemDescricao(jovem.getDescricao());
        log.setJovemGenero(jovem.getGenero());
        log.setJovemDataNasc(jovem.getDataNasc());
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}

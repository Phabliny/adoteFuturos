package com.cursos.curso.message;

import com.cursos.curso.model.Action;
import com.cursos.curso.model.Curso;
import com.cursos.curso.model.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CursoSendMessage {
    @Value("${curso.rabbitmq.exchange}")
    String exchange;

    @Value("${curso.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Curso curso, Action action) {
        Log log = new Log();
        log.setAction(action);
        log.setDataLog(log.getDataLog());
        log.setCursoNome(curso.getNome());
        log.setCursoDescricao(curso.getDescricao());
        log.setCursoCargaHoraria(curso.getCargaHoraria());
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}

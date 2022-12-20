package com.apoiadores.apoiador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private String id;
    private Action action = Action.NONE;
    private Date dataLog = new Date();
    private String apoiadorNome;
    private String apoiadorCpf;
    private String apoiadorTelefone;
}

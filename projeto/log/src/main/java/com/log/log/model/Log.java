package com.log.log.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "log")
public class Log {
    @Id
    private String id;
    private Action action = Action.NONE;
    private Date dataLog = new Date();
    private String nomeInstituicao;
    private String cnpjInstituicao;
    private String enderecoInstituicao;
    private String jovemNome;
    private String jovemDataNasc;
    private String jovemGenero;
    private String jovemDescricao;
    private String jovemApoiado;
    private String jovemCurso;
    private String jovemApoiador;
    private String apoiadorNome;
    private String apoiadorCpf;
    private String apoiadorTelefone;
    private String cursoNome;
    private String cursoDescricao;
    private String cursoCargaHoraria;
}

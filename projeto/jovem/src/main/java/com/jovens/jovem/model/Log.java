package com.jovens.jovem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private String id;
    private Action action = Action.NONE;
    private Date dataLog = new Date();
    private String jovemNome;
    private String jovemDataNasc;
    private String jovemGenero;
    private String jovemDescricao;
    private String jovemApoiado;
    private String jovemCurso;
    private Boolean jovemApoiador;
}

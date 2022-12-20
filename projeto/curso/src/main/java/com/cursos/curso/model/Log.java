package com.cursos.curso.model;

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
    private String cursoNome;
    private String cursoDescricao;
    private String cursoCargaHoraria;
}

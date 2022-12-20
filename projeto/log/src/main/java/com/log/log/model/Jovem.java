package com.log.log.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jovem {
    private String id;
    private String nome;
    private String dataNasc;
    private String genero;
    private String descricao;
    private Boolean apoiado;
    private Apoiador apoiador;
    private Curso curso;
    private List<Instituicao> instituicoes = new ArrayList<>();
}

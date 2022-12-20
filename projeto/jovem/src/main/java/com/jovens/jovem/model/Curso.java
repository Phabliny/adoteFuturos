package com.jovens.jovem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private String id;
    private String nome;
    private String descricao;
    private String cargaHoraria;
    private List<Instituicao> instituicoes = new ArrayList<>();
}

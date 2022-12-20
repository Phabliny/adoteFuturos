package com.cursos.curso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cursos")
public class Curso {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private String cargaHoraria;
    private List<Instituicao> instituicoes = new ArrayList<>();
}

package com.jovens.jovem.model;

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
@Document(collection = "jovens")
public class Jovem {
    @Id
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

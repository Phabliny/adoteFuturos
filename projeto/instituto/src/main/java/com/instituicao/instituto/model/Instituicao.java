package com.instituicao.instituto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "institutos")
public class Instituicao {
    @Id
    private String id;
    private String nome;
    private String cnpj;
    private String endereco;
    @DBRef
    private List<Jovem> jovens = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
}

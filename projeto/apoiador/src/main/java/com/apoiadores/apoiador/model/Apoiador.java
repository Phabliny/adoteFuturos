package com.apoiadores.apoiador.model;

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
@Document(collection = "apoiadores")
public class Apoiador {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String telefone;
    @DBRef
    private List<Jovem> jovens = new ArrayList<>();
}

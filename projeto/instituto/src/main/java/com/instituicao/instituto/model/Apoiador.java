package com.instituicao.instituto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apoiador {
    private String id;
    private String nome;
    private String cpf;
    private String telefone;
    private List<Jovem> jovens = new ArrayList<>();
}

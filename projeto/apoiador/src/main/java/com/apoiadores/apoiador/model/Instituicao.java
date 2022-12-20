package com.apoiadores.apoiador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instituicao {
    private String id;
    private String nome;
    private String cnpj;
    private String endereco;
    private List<Jovem> jovens = new ArrayList<>();
}

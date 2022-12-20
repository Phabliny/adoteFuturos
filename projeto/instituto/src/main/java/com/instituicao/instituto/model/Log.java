package com.instituicao.instituto.model;

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
    private String nomeInstituicao;
    private String cnpjInstituicao;
    private String enderecoInstituicao;
}

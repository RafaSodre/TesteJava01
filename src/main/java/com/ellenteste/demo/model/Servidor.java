package com.ellenteste.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@AllArgsConstructor
@Data
public class Servidor {
    @NotEmpty
    private String nome;

    @NotEmpty
    private Long matricula;

    private Date data;

    @NotEmpty
    private Lotacao lotacao;
}

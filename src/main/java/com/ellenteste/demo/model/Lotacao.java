package com.ellenteste.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@AllArgsConstructor
@Data
public class Lotacao {

    private Long id;

    @NotEmpty
    private String descricao;

    private Date dataCadastro;
}

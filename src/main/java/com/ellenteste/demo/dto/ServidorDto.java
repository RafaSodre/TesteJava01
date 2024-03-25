package com.ellenteste.demo.dto;

import lombok.Data;


@Data
public class ServidorDto {
    private Long id;
    private String nome;
    private String cpf;
    private Long idLotacao;
}

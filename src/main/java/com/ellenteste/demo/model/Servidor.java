package com.ellenteste.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Servidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long matricula;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cpf;
    private Date data;
    @NotNull
    private Long idLotacao;

    public Servidor(String nome, String cpf, Date data, Long idLotacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.data = data;
        this.idLotacao = idLotacao;
    }
}

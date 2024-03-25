package com.ellenteste.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Lotacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Voce precisa adicionar um nome")
    private String nome;

    private Date dataCadastro;

    public Lotacao(String nome, Date dataCadastro) {
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }
}

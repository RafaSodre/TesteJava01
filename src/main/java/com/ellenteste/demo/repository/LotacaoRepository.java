package com.ellenteste.demo.repository;

import com.ellenteste.demo.model.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao,Long> {

    Optional<Lotacao> findByNome(String nome);
}

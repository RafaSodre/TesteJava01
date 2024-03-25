package com.ellenteste.demo.repository;

import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long> {

    Optional<Servidor> findById(Long id);
    Optional<Servidor> findByCpf(String cpf);
    List<Servidor> findAllByIdLotacao(Long idLotacao);

}

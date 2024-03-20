package com.ellenteste.demo.repository;

import com.ellenteste.demo.model.Servidor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository {

    Servidor findById(Long id);
}

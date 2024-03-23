package com.ellenteste.demo.service;

import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.model.Servidor;
import com.ellenteste.demo.repository.LotacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class LotacaoService {

    private final LotacaoRepository lotacaoRepository;

    public LotacaoService(LotacaoRepository lotacaoRepository) {
        this.lotacaoRepository = lotacaoRepository;
    }

    public Lotacao findLotacaoByNome(String nome){
        return lotacaoRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Nenhuma Lotacao foi encontrada com o nome: " + nome));
    }

    public Lotacao saveLotacao(Lotacao lotacao){
        return lotacaoRepository.save(lotacao);
    }
}

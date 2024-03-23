package com.ellenteste.demo.service;

import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.model.Servidor;
import com.ellenteste.demo.repository.ServidorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServidorService {


    private final ServidorRepository servidorRepository;
    private final LotacaoService lotacaoService;

    public ServidorService(ServidorRepository servidorRepository, LotacaoService lotacaoService) {
        this.servidorRepository = servidorRepository;
        this.lotacaoService = lotacaoService;
    }

    public Servidor saveServidor(Servidor servidor){
        lotacaoService.findLotacaoByNome(servidor.getLotacao().getNome());
        return servidorRepository.save(servidor);
    }
    public Servidor findServidor(Long matricula){
        return servidorRepository.findById(matricula).orElseThrow(() -> new RuntimeException("Nenhum servidor foi encontrado com a matricula " + matricula));
    }
}

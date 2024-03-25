package com.ellenteste.demo.service;

import com.ellenteste.demo.exception.exceptions.ServidorNaoExisteException;
import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.model.Servidor;
import com.ellenteste.demo.repository.ServidorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorService {


    private final ServidorRepository servidorRepository;
    private final LotacaoService lotacaoService;

    public ServidorService(ServidorRepository servidorRepository, LotacaoService lotacaoService) {
        this.servidorRepository = servidorRepository;
        this.lotacaoService = lotacaoService;
    }

    public void deleteServidor(Long id) {
        findServidor(id);
        servidorRepository.deleteById(id);
    }

    public Servidor saveServidor(Servidor servidor){
        lotacaoService.findLotacaoById(servidor.getIdLotacao());
        return servidorRepository.save(servidor);
    }
    public Servidor findServidor(Long matricula){
        return servidorRepository.findById(matricula).orElseThrow(() -> new ServidorNaoExisteException("Nenhum servidor foi encontrado com a matricula " + matricula));
    }
    public List<Servidor> findServidoresByIdLotacao(Long idLotacao){
        return servidorRepository.findAllByIdLotacao(idLotacao);
    }
}

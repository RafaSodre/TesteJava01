package com.ellenteste.demo.service;

import com.ellenteste.demo.dto.LotacaoDto;
import com.ellenteste.demo.exception.exceptions.LotacaoComNomeJaExistenteException;
import com.ellenteste.demo.exception.exceptions.LotacaoNaoExisteException;
import com.ellenteste.demo.exception.exceptions.LotacaoPossuiServidoresException;
import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.model.Servidor;
import com.ellenteste.demo.repository.LotacaoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LotacaoService {

    private final LotacaoRepository lotacaoRepository;
    private final ServidorService servidorService;

    public LotacaoService(LotacaoRepository lotacaoRepository, @Lazy ServidorService servidorService) {
        this.lotacaoRepository = lotacaoRepository;
        this.servidorService = servidorService;
    }

    public Lotacao findLotacaoByNome(String nome){
        return lotacaoRepository.findByNome(nome).orElseThrow(() -> new LotacaoNaoExisteException("Nenhuma Lotacao foi encontrada com o nome: " + nome));
    }
    public Lotacao findLotacaoById(Long id){
        return lotacaoRepository.findById(id).orElseThrow(() -> new LotacaoNaoExisteException("Nenhuma Lotacao foi encontrada com o id: " + id));
    }
    public List<Lotacao> listarTodasLotacoes(){
        return lotacaoRepository.findAll();
    }

    public Lotacao saveLotacao(String nome){
        lotacaoNomeJaExiste(nome);
        Lotacao lotacao = new Lotacao(nome,new Date());
        return lotacaoRepository.save(lotacao);
    }

    public void deleteLotacao(Long idLotacao){
        findLotacaoById(idLotacao);
        List<Servidor> servidoresbyLotacao = servidorService.findServidoresByIdLotacao(idLotacao);
        if (servidoresbyLotacao.isEmpty()){
            lotacaoRepository.deleteById(idLotacao);
        }else {
            throw new LotacaoPossuiServidoresException("Essa Lotacao possui servidores");
        }
    }

    public Lotacao editarLotacao(LotacaoDto lotacaoDto) {
        Lotacao lotacaoById = findLotacaoById(lotacaoDto.getId());
        lotacaoNomeJaExiste(lotacaoDto.getNome());
        Lotacao lotacao = new Lotacao(lotacaoDto.getId(),lotacaoDto.getNome(),lotacaoById.getDataCadastro());
        return lotacaoRepository.save(lotacao);
    }
    private void lotacaoNomeJaExiste(String nome){
        Optional<Lotacao> lotacao = lotacaoRepository.findByNome(nome);
        if (lotacao.isPresent()) {
            throw new LotacaoComNomeJaExistenteException("Ja existe Lotacao com o nome: " + nome);
        }
    }
}

package com.ellenteste.demo.service;

import com.ellenteste.demo.dto.ServidorDto;
import com.ellenteste.demo.exception.exceptions.LotacaoComNomeJaExistenteException;
import com.ellenteste.demo.exception.exceptions.ServidorJaExisteException;
import com.ellenteste.demo.exception.exceptions.ServidorNaoExisteException;
import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.model.Servidor;
import com.ellenteste.demo.repository.ServidorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Servidor saveServidor(ServidorDto servidorDto){
        lotacaoService.findLotacaoById(servidorDto.getIdLotacao());
        servidorCpfJaExiste(servidorDto.getCpf());
        Servidor servidor = new Servidor(servidorDto.getNome(),servidorDto.getCpf(), new Date(), servidorDto.getIdLotacao());
        return servidorRepository.save(servidor);
    }
    public Servidor findServidor(Long matricula){
        return servidorRepository.findById(matricula).orElseThrow(() -> new ServidorNaoExisteException("Nenhum servidor foi encontrado com a matricula " + matricula));
    }
    public List<Servidor> findServidoresByIdLotacao(Long idLotacao){
        return servidorRepository.findAllByIdLotacao(idLotacao);
    }

    public Servidor editarServidor(ServidorDto servidorDto) {
        Servidor servidor = findServidor(servidorDto.getId());
        if (servidorDto.getIdLotacao() != null){
            lotacaoService.findLotacaoById(servidorDto.getIdLotacao());
        }
        if (servidorDto.getCpf() != null && !servidor.getCpf().equals(servidorDto.getCpf())){
            servidorCpfJaExiste(servidorDto.getCpf());
        }
        Servidor servidorEditado = new Servidor(servidor.getMatricula(),servidorDto.getNome(),servidorDto.getCpf(),servidor.getData(),servidorDto.getIdLotacao());
        return servidorRepository.save(servidorEditado);
    }

    private void servidorCpfJaExiste(String cpf){
        Optional<Servidor> servidor = servidorRepository.findByCpf(cpf);
        if (servidor.isPresent()){
            throw new ServidorJaExisteException("Ja existe servidor com o cpf: " + cpf);
        }
    }
}

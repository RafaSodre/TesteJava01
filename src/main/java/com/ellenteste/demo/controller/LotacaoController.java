package com.ellenteste.demo.controller;

import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.service.LotacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {

    private final LotacaoService lotacaoService;

    public LotacaoController(LotacaoService lotacaoService) {
        this.lotacaoService = lotacaoService;
    }

    @PostMapping("/cadastrarLocatao")
    public Lotacao cadastrarLocatao(@RequestBody Lotacao lotacao){
        return lotacaoService.saveLotacao(lotacao);
    }
    @GetMapping("/buscarLotacaoPorNome/{nomeLotacao}")
    public Lotacao buscarLotacaoPorNome(@PathVariable String nomeLotacao){
        return lotacaoService.findLotacaoByNome(nomeLotacao);
    }

}

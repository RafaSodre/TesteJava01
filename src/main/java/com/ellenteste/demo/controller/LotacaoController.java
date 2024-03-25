package com.ellenteste.demo.controller;

import com.ellenteste.demo.dto.LotacaoDto;
import com.ellenteste.demo.model.Lotacao;
import com.ellenteste.demo.service.LotacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {

    private final LotacaoService lotacaoService;

    public LotacaoController(LotacaoService lotacaoService) {
        this.lotacaoService = lotacaoService;
    }

    @Operation(summary = "Cadastrar uma nova lotação")
    @PostMapping("/cadastrarLocatao")
    public Lotacao cadastrarLocatao(@Valid @RequestParam String nome){
        return lotacaoService.saveLotacao(nome);
    }

    @Operation(summary = "Editar uma lotação existente")
    @PutMapping("/editarLotacao")
    public Lotacao editarLotacao(@RequestBody LotacaoDto lotacaoDto){
        return lotacaoService.editarLotacao(lotacaoDto);
    }

    @Operation(summary = "Buscar uma lotação pelo nome")
    @GetMapping("/buscarLotacaoPorNome/{nomeLotacao}")
    public Lotacao buscarLotacaoPorNome(@PathVariable String nomeLotacao){
        return lotacaoService.findLotacaoByNome(nomeLotacao);
    }

    @Operation(summary = "Listar todas as lotações")
    @GetMapping("/listarTodasLotacoes")
    public ResponseEntity<List<Lotacao>> buscarLotacaoPorNome(){
        return ResponseEntity.ok(lotacaoService.listarTodasLotacoes());
    }

    @Operation(summary = "Deletar uma lotação pelo ID")
    @DeleteMapping("deletarLotacao/{id}")
    public ResponseEntity deletarLotacao(
            @Parameter(description = "ID da lotação a ser deletada", example = "1") @PathVariable Long id){
        lotacaoService.deleteLotacao(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Lotacao deletada com sucesso");
    }
}

package com.ellenteste.demo.controller;

import com.ellenteste.demo.dto.ServidorDto;
import com.ellenteste.demo.model.Servidor;
import com.ellenteste.demo.service.ServidorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servidor")
public class ServidorController {

    private final ServidorService servidorService;

    public ServidorController(ServidorService servidorService) {
        this.servidorService = servidorService;
    }

    @Operation(summary = "Cadastrar um novo servidor")
    @PostMapping("/cadastrarServidor")
    public Servidor cadastrarServidor(@RequestBody ServidorDto servidorDto){
        return servidorService.saveServidor(servidorDto);
    }

    @Operation(summary = "Editar informações de um servidor existente")
    @PutMapping("/editarServidor")
    public Servidor editarServidor(@RequestBody ServidorDto servidorDto){
        return servidorService.editarServidor(servidorDto);
    }

    @Operation(summary = "Buscar informações de um servidor pelo ID")
    @GetMapping("/buscarServidor")
    public Servidor buscarServidor(@Parameter(description = "Matrícula do servidor a ser buscado", required = true)
                                   @RequestParam Long matricula){
        return servidorService.findServidor(matricula);
    }

    @Operation(summary = "Deletar um servidor pelo ID")
    @DeleteMapping("deletarServidor/{id}")
    public ResponseEntity deletarServidor(@Parameter(description = "ID do servidor a ser deletado", required = true)
                                          @PathVariable Long id){
        servidorService.deleteServidor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Servidor deletado com sucesso");
    }
}

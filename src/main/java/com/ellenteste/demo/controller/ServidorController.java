package com.ellenteste.demo.controller;
import com.ellenteste.demo.model.Servidor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Servidor")
public class ServidorController {

    @PostMapping("/cadastrarServidor")
    public String cadastrarServidor(@RequestBody Servidor servidor){
        return "show";
    }

    @GetMapping("/buscarServidor")
    public ResponseEntity<Servidor> buscarServidor(@RequestParam Long matricula){
        return null;
    }
}

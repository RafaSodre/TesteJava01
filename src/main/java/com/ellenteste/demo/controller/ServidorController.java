package com.ellenteste.demo.controller;
import com.ellenteste.demo.model.Servidor;
import com.ellenteste.demo.service.ServidorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servidor")
public class ServidorController {

    private final ServidorService servidorService;

    public ServidorController(ServidorService servidorService) {
        this.servidorService = servidorService;
    }

    @PostMapping("/cadastrarServidor")
    public Servidor cadastrarServidor(@RequestBody Servidor servidor){
        return servidorService.saveServidor(servidor);
    }

    @GetMapping("/buscarServidor")
    public Servidor buscarServidor(@RequestParam Long matricula){
        return servidorService.findServidor(matricula);
    }
}

package br.com.g1bet.controller;

import br.com.g1bet.model.Partida;
import br.com.g1bet.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partida")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartidaController {

    @Autowired
    private PartidaService service;

    @GetMapping("/historico/{idTime}")
    public ResponseEntity<List<Partida>>exibirHistoricoPartida(@PathVariable Long idTime){
        return ResponseEntity.ok(service.exibirHistoricoPartida(idTime));
    }
}

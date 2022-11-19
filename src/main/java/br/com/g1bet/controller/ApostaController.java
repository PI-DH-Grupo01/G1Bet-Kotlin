package br.com.g1bet.controller;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.TipoApostaEnum;
import br.com.g1bet.model.dto.ApostaDTO;
import br.com.g1bet.model.dto.ApostaResponse;
import br.com.g1bet.service.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apostas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApostaController {

    @Autowired
    private ApostaService service;

    @GetMapping
    public ResponseEntity<List<Aposta>> getAll() {
        return (ResponseEntity<List<Aposta>>) service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApostaResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/tipo/{tipoDeAposta}")
    public ResponseEntity<List<Aposta>> getByAposta(@PathVariable TipoApostaEnum tipoDeAposta) {
        return (ResponseEntity<List<Aposta>>) service.findAllByTipo(tipoDeAposta);

    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody ApostaDTO apostaModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(apostaModel));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/historico/{idUsuario}")
    public ResponseEntity<List<Aposta>> exibirHistorico(@PathVariable Long idUsuario){
        return  ResponseEntity.ok(service.exibirHistorico(idUsuario));
    }


}

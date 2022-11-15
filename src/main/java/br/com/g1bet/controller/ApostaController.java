package br.com.g1bet.controller;

import br.com.g1bet.model.Aposta;
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
    public ResponseEntity<List<Aposta>> getAll() { return (ResponseEntity<List<Aposta>>) service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Aposta> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/aposta/{tipoDeAposta}")
    public ResponseEntity<List<Aposta>> getByAposta(@PathVariable String tipoDeAposta) {
        return (ResponseEntity<List<Aposta>>) service.findAllByTipoContainingIgnoreCase(tipoDeAposta);

    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Aposta apostaModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(apostaModel));
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestBody Aposta apostaModel) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(apostaModel));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/historico/{idUsuario}")
    public ResponseEntity<List<Aposta>> exibirHistorico(@PathVariable Long idUsuario){
        return  ResponseEntity.ok(repository.findByUsuarioId(idUsuario));
    }


}

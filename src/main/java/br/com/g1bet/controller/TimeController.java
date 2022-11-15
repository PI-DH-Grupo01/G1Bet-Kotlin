package br.com.g1bet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.g1bet.model.Time;
import br.com.g1bet.repository.TimeRepository;

@RestController
@RequestMapping("/times")
@CrossOrigin("*")
public class TimeController {
    @Autowired
    private TimeRepository repository;

    @GetMapping
    public ResponseEntity<List<Time>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/times/{time}")
    public ResponseEntity<List<Time>> getByTime(@PathVariable String nome) {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));

    }

    @PostMapping
    public ResponseEntity<Time> post(@RequestBody Time timeModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(timeModel));
    }

    @PutMapping
    public ResponseEntity<Time> put(@RequestBody Time timeModel) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(timeModel));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }


}

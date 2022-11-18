package br.com.g1bet.service;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.TipoApostaEnum;
import br.com.g1bet.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository repository;

    public Object findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Aposta> findById(Long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Aposta>> findAllByTipo(TipoApostaEnum tipoDeAposta) {
        return ResponseEntity.ok(repository.findAllByTipo(tipoDeAposta));
    }

    public Object save(Aposta apostaModel) {
        return repository.save(apostaModel);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Aposta> exibirHistorico(Long idUsuario){
        return repository.findByUsuarioId(idUsuario);
    }
}

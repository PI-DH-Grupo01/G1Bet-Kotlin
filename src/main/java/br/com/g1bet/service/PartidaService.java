package br.com.g1bet.service;

import br.com.g1bet.model.Partida;
import br.com.g1bet.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository repository;

    public List<Partida> exibirHistoricoPartida(Long idTime){
        List<Partida> visitantes = repository.findAllByTimeVisitante_Id(idTime);
        List<Partida> casa = repository.findAllByTimeCasa_Id(idTime);
        visitantes.addAll(casa);
        return visitantes;
    }
}

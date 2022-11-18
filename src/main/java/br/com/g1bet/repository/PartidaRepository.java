package br.com.g1bet.repository;

import br.com.g1bet.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findAllByTimeVisitante_Id(Long id);

    List<Partida> findAllByTimeCasa_Id(Long id);
}

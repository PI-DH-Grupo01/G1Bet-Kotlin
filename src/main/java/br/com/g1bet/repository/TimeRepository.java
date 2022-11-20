package br.com.g1bet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.g1bet.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    List<Time> findAllByNomeContainingIgnoreCase(String nome);

    Boolean existsByNome(String nome);

}

package br.com.g1bet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.g1bet.model.TimeModel;

@Repository
public interface TimeRepository extends JpaRepository <TimeModel, Long> {
	public List<TimeModel> findAllByNomeContainingIgnoreCase(String nome);

}

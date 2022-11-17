package br.com.g1bet.repository;

import br.com.g1bet.model.Aposta;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {
    List<Aposta> findAllByTipoContainingIgnoreCase(String tipo);

    List<Aposta> findByUsuarioId(Long id);
}

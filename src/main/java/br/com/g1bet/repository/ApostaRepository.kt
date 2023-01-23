package br.com.g1bet.repository

import br.com.g1bet.model.Aposta
import br.com.g1bet.model.TipoApostaEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ApostaRepository : JpaRepository<Aposta?, Long?> {
    fun findByUsuarioId(id: Long?): List<Aposta?>?
    fun findAllByTipo(tipoDeAposta: TipoApostaEnum?): List<Aposta?>?
}
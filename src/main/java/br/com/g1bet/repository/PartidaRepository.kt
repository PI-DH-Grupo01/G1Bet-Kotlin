package br.com.g1bet.repository

import br.com.g1bet.model.Partida
import org.springframework.data.jpa.repository.JpaRepository

interface PartidaRepository : JpaRepository<Partida?, Long?> {
    fun findAllByTimeVisitante_Id(id: Long?): List<Partida?>?
    fun findAllByTimeCasa_Id(id: Long?): List<Partida?>?
}
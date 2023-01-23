package br.com.g1bet.repository

import br.com.g1bet.model.Time
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TimeRepository : JpaRepository<Time?, Long?> {
    fun findAllByNomeContainingIgnoreCase(nome: String?): List<Time?>?
    fun existsByNome(nome: String?): Boolean?
}
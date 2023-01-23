package br.com.g1bet.repository

import br.com.g1bet.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsuarioRepository : JpaRepository<Usuario?, Long?> {
    fun findByEmail(email: String?): Optional<Usuario?>?
    fun existsByEmail(email: String?): Boolean?
}
package br.com.g1bet.security

import br.com.g1bet.model.Usuario
import br.com.g1bet.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class UserDetailsServiceImpl : UserDetailsService {
    @Autowired
    private val usuarioRepository: UsuarioRepository? = null
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String?): UserDetailsImpl {
        val usuario: Optional<Usuario?>? = usuarioRepository.findByEmail(email)
        if (usuario != null) {
            return if (usuario.isPresent()) UserDetailsImpl(usuario.get()) else throw ResponseStatusException(HttpStatus.FORBIDDEN)
        }
    }
}
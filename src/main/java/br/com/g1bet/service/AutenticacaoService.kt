package br.com.g1bet.service

import br.com.g1bet.repository.UsuarioRepository
import br.com.g1bet.security.UserDetailsImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AutenticacaoService(private val repository: UsuarioRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val usuario = repository.findByEmail(username)
        if (usuario!!.isPresent) return UserDetailsImpl(usuario.get())
        throw UsernameNotFoundException("Dados ínvalidos $username")
    }
}
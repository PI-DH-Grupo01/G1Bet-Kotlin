package br.com.g1bet.security

import br.com.g1bet.model.Usuario
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl : UserDetails, UserDetails {
    var username: String? = null
        private set
    var password: String? = null
        private set

    constructor(user: Usuario) {
        username = user.getEmail()
        password = user.getSenha()
    }

    constructor() {}

    val authorities: Collection<Any?>?
        get() = null
    val isAccountNonExpired: Boolean
        get() = true
    val isAccountNonLocked: Boolean
        get() = true
    val isCredentialsNonExpired: Boolean
        get() = true
    val isEnabled: Boolean
        get() = true

    companion object {
        private const val serialVersionUID = 1L
    }

}
package br.com.g1bet.security

import br.com.g1bet.model.Usuario
import com.auth0.jwt.JWT
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.Elements.JWT
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthentication(authenticationManager: AuthenticationManager) : UsernamePasswordAuthenticationFilter() {
    private val authenticationManager: AuthenticationManager

    init {
        this.authenticationManager = authenticationManager
    }

    @Throws(AuthenticationException::class)
    fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication {
        // busca as credenciais digitadas pelo usuário
        var usuario: Usuario? = null
        usuario = try {
            ObjectMapper().readValue(request.getInputStream(), Usuario::class.java)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        val authResult = UsernamePasswordAuthenticationToken(
                usuario.getEmail(),
                usuario.getSenha()
        )
        return authenticationManager.authenticate(authResult)
    }

    protected fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse, chain: FilterChain?, authResult: Authentication) {
        val username: String = (authResult.getPrincipal() as UserDetails).getUsername()
        val token: String = JWT.create()
                .withSubject(username)
                .withExpiresAt(Date(System.currentTimeMillis() + EXPIRATION))
                .sign(Algorithm.HMAC512(senha.toByteArray()))
        val headerBody = "$username $token"
        response.setHeader(HttpHeaders.AUTHORIZATION, headerBody)
    }

    companion object {
        private const val EXPIRATION: Long = 600000
        private const val senha = "APOSTAS G1BET"
    }
}


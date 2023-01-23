package br.com.g1bet.security

import com.auth0.jwt.JWT
import org.springframework.security.authentication.AuthenticationManager
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest

class JWTAuthorization(authenticationManager: AuthenticationManager?) : BasicAuthenticationFilter(authenticationManager) {
    @Throws(ServletException::class, IOException::class)
    protected fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse?, filterChain: FilterChain) {
        val token: String = request.getHeader("Authorization")
        if (token == null || !token.startsWith(token_prefix)) {
            filterChain.doFilter(request, response)
            return
        }
        val auth: UsernamePasswordAuthenticationToken? = getAuthentication(token)

        // define o usuário como autenticado no contexto da aplicação
        SecurityContextHolder.getContext().setAuthentication(auth)
        filterChain.doFilter(request, response)
    }

    fun getAuthentication(token: String?): UsernamePasswordAuthenticationToken? {
        if (token == null) {
            return null
        }

        // decodifica o token para recuperar o username
        val username: String = JWT.require(Algorithm.HMAC512(senha.toByteArray()))
                .build()
                .verify(token.replace(token_prefix, ""))
                .getSubject() ?: return null

        // substituir por
        return UsernamePasswordAuthenticationToken(
                username, null, emptyList())
    }

    companion object {
        // prefixo do token que será recebido no HttpServletRequest
        private const val token_prefix = "Bearer "

        // segredo: substituir para uma string codificada
        private const val senha = "APOSTAS G1BET"
    }
}
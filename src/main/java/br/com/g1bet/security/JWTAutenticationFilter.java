package br.com.g1bet.security;

import br.com.g1bet.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAutenticationFilter extends UsernamePasswordAuthenticationFilter{

    public static final int TOKEN_EXPIRATION = 600_000;

    public static final String TOKEN_SENHA = "30cb6371-46f0-4baa-bf5f-8c58df6ef0d6";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(),
                    usuario.getSenha()
            ));
        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuário!", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(userDetails.getUsername()).
                withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION)).
                sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}

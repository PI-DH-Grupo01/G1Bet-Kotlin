package br.com.g1bet.service;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.repository.UsuarioRepository;
import br.com.g1bet.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(username);

        if (usuario.isPresent())
            return new UserDetailsImpl(usuario.get());
        throw new UsernameNotFoundException("Dados ínvalidos " + username);
    }

}

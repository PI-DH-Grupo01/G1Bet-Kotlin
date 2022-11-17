package br.com.g1bet.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    public Usuario cadastrar(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);
        return repository.save(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private Usuario findById(Long id) {
        Optional<Usuario> atualizarUsuario = repository.findById(id);
        return atualizarUsuario.orElseThrow(() -> new ObjectNotFoundException("Id: " + id, "Usuario não encontrado"));
    }

    public Usuario atualizar(Usuario usuario, Long id) {
        Usuario atualizarUsuario = findById(id);
        atualizarUsuario.setNome(usuario.getNome());
        atualizarUsuario.setCpf(usuario.getCpf());
        atualizarUsuario.setDataDeNascimento(usuario.getDataDeNascimento());
        atualizarUsuario.setEmail(usuario.getEmail());
        atualizarUsuario.setSenha(usuario.getSenha());
        atualizarUsuario.setChavePix(usuario.getChavePix());
        atualizarUsuario.setSaldoUsuario(usuario.getSaldoUsuario());
        return repository.save(atualizarUsuario);
    }

}

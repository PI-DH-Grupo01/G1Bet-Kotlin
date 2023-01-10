package br.com.g1bet.service;

import br.com.g1bet.exceptions.CampoExistenteException;
import br.com.g1bet.exceptions.CampoNullException;
import br.com.g1bet.model.Usuario;
import br.com.g1bet.model.dto.UsuarioRequest;
import br.com.g1bet.model.dto.UsuarioResponse;
import br.com.g1bet.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioResponse cadastrar(UsuarioRequest usuarioRequest) {
        if (repository.existsByEmail(usuarioRequest.getEmail())) {
            throw new CampoExistenteException("Esse email já existe!");
        }
        if (usuarioRequest.getSenha() == null
                || usuarioRequest.getEmail() == null
                || usuarioRequest.getDataDeNascimento() == null
                || usuarioRequest.getNome() == null) {
            throw new CampoNullException("Campo obrigatório não pode ser nulo");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setDataDeNascimento(usuarioRequest.getDataDeNascimento());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(encoder.encode(usuarioRequest.getSenha()));
        usuario.setChavePix(usuarioRequest.getChavePix());
        usuario.setSaldoUsuario(usuarioRequest.getSaldoUsuario());

        usuario = repository.save(usuario);
        return UsuarioResponse.toUsuarioResponse(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Id: " + id, "Usuario não encontrado"));
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

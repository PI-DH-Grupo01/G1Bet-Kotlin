package br.com.g1bet.service;

import br.com.g1bet.exceptions.CampoExistenteException;
import br.com.g1bet.exceptions.CampoNullException;
import br.com.g1bet.model.Usuario;
import br.com.g1bet.model.dto.UsuarioDTO;
import br.com.g1bet.model.dto.UsuarioResponse;
import br.com.g1bet.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UsuarioResponse cadastrar(UsuarioDTO usuarioDTO) {
        if (repository.existsByEmail(usuarioDTO.getEmail())) {
            throw new CampoExistenteException("Esse email já existe!");
        }
        if (usuarioDTO.getSenha() == null
                || usuarioDTO.getEmail() == null
                || usuarioDTO.getDataDeNascimento() == null
                || usuarioDTO.getNome() == null) {
            throw new CampoNullException("Campo obrigatório não pode ser nulo");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setDataDeNascimento(usuarioDTO.getDataDeNascimento());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(encoder.encode(usuarioDTO.getSenha()));
        usuario.setChavePix(usuarioDTO.getChavePix());
        usuario.setSaldoUsuario(usuarioDTO.getSaldoUsuario());

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

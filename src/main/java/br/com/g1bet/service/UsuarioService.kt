package br.com.g1bet.service

import br.com.g1bet.dto.request.UsuarioRequest
import br.com.g1bet.dto.response.UsuarioResponse
import br.com.g1bet.mapper.UsuarioMapper
import br.com.g1bet.mapper.exceptions.CampoExistenteException
import br.com.g1bet.mapper.exceptions.IdNaoExisteException
import br.com.g1bet.model.Usuario
import br.com.g1bet.repository.UsuarioRepository
import lombok.RequiredArgsConstructor
import org.hibernate.ObjectNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class UsuarioService {
    private val repository: UsuarioRepository? = null
    private val encoder: PasswordEncoder? = null
    fun cadastrar(usuarioRequest: UsuarioRequest): UsuarioResponse {
        if (repository!!.existsByEmail(usuarioRequest.email)!!) {
            throw CampoExistenteException("Esse email já existe!")
        }
        val usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioRequest)
        return UsuarioResponse.toUsuarioResponse(repository.save(usuario))
    }

    fun deletar(id: Long) {
        if (!repository!!.existsById(id)) {
            throw IdNaoExisteException("ID nao encontrado")
        }
        repository.deleteById(id)
    }

    fun buscar(id: Long): Usuario {
        return repository!!.findById(id)
                .orElseThrow { ObjectNotFoundException("Id: $id", "Usuario não encontrado") }!!
    }

    fun atualizar(usuario: Usuario, id: Long): Usuario {
        val atualizarUsuario = buscar(id)
        atualizarUsuario.setNome(usuario.getNome())
        atualizarUsuario.setCpf(usuario.getCpf())
        atualizarUsuario.setDataDeNascimento(usuario.getDataDeNascimento())
        atualizarUsuario.setEmail(usuario.getEmail())
        atualizarUsuario.setSenha(usuario.getSenha())
        atualizarUsuario.setChavePix(usuario.getChavePix())
        atualizarUsuario.setSaldoUsuario(usuario.getSaldoUsuario())
        return repository!!.save(atualizarUsuario)
    }
}
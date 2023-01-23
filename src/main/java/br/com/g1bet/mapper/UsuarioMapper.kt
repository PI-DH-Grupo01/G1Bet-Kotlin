package br.com.g1bet.mapper

import br.com.g1bet.dto.request.UsuarioRequest
import br.com.g1bet.model.Usuario
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface UsuarioMapper {
    fun toUsuario(usuarioRequest: UsuarioRequest?): Usuario?

    companion object {
        @JvmField
        val INSTANCE: UsuarioMapper = Mappers.getMapper(UsuarioMapper::class.java)
    }
}
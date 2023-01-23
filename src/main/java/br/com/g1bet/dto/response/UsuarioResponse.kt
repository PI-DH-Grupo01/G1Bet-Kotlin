package br.com.g1bet.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDate

@Data
@AllArgsConstructor
@NoArgsConstructor
class UsuarioResponse(id: Any?, nome: Any?, dataDeNascimento: Any?, email: Any?, saldoUsuario: Any?) {
    private val id: Long? = null
    private val nome: String? = null

    @JsonFormat(pattern = "dd/MM/yyyy")
    private val dataDeNascimento: LocalDate? = null
    private val email: String? = null
    private val saldoUsuario: Double? = null

    companion object {
        fun toUsuarioResponse(usuario: Usuario): UsuarioResponse {
            return UsuarioResponse(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getDataDeNascimento(),
                    usuario.getEmail(),
                    usuario.getSaldoUsuario()
            )
        }
    }
}
package br.com.g1bet.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.Data
import java.time.LocalDate

@Data
class UsuarioRequest {
    private val nome: String? = null
    private val cpf: Long? = null

    @JsonFormat(pattern = "dd/MM/yyyy")
    private val dataDeNascimento: LocalDate? = null
    private val email: String? = null
    private val senha: String? = null
    private val chavePix: String? = null
    private val saldoUsuario: Double? = null
}
package br.com.g1bet.model

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null
    private val nome: String? = null
    private val cpf: Long? = null

    @JsonFormat(pattern = "dd/MM/yyyy")
    private val dataDeNascimento: LocalDate? = null
    private val email: String? = null
    private val senha: String? = null
    private val chavePix: String? = null
    private val saldoUsuario: Double? = null
}
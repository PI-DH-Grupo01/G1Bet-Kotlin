package br.com.g1bet.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "id_time_visitante", referencedColumnName = "id")
    var timeVisitante: Time? = null

    @ManyToOne
    @JoinColumn(name = "id_time_casa", referencedColumnName = "id")
    var timeCasa: Time? = null

    @NotNull
    @Size(min = 5, max = 20)
    var resultado: String? = null

    @Column(name = "data_hora_partida")
    @JsonFormat(pattern = "dd/MM/yyyy")
    var dataHora: LocalDateTime? = null
}
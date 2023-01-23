package br.com.g1bet.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @NotNull
    @Size(min = 5, max = 100)
    var nome: String? = null

    @OneToMany(mappedBy = "timeCasa", cascade = arrayOf(CascadeType.ALL))
    @JsonIgnore
    private val partidasCasa: List<Partida>? = null

    @OneToMany(mappedBy = "timeVisitante", cascade = arrayOf(CascadeType.ALL))
    @JsonIgnore
    private val partidasVisitante: List<Partida>? = null
}
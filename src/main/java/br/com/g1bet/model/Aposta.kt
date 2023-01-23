package br.com.g1bet.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Aposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "id_usuario")
    var usuario: Usuario? = null

    @ManyToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "id_partida")
    var partida: Partida? = null

    @javax.validation.constraints.NotNull
    @Column(name = "tipo_de_aposta")
    @Enumerated(EnumType.STRING)
    var tipo: TipoApostaEnum? = null

    @javax.validation.constraints.NotNull
    var valorApostado: Double? = null

    @javax.validation.constraints.NotNull
    var odd = Math.random() * 5
        get() = arredondarParaDuasCasas(field)

    companion object {
        fun arredondarParaDuasCasas(d: Double): Double {
            return (if (d < 0) d * 100 - 0.5 else d * 100 + 0.5).toLong() / 100.0
        }
    }
}
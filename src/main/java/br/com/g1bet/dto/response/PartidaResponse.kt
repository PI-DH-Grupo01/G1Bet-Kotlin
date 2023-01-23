package br.com.g1bet.dto.response

import java.time.LocalDateTime

class PartidaResponse {
    var timeCasa: String? = null
    var timeVisitante: String? = null
    var dataHora: LocalDateTime? = null
    var resultado: String? = null
        get() = if (field == null) {
            "Partida iniciará"
        } else field
}
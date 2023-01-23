package br.com.g1bet.dto.request

import br.com.g1bet.model.TipoApostaEnum

class ApostaRequest {
    var usuario: Long? = null
    var partida: Long? = null
    var tipo: TipoApostaEnum? = null
    var valorApostado: Double? = null
    var possivelRetorno: Double? = null
}
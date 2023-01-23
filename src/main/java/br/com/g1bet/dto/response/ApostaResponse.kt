package br.com.g1bet.dto.response

import br.com.g1bet.model.Aposta
import br.com.g1bet.model.TipoApostaEnum
import java.text.DecimalFormat

class ApostaResponse {
    var id: Long? = null
    var usuario: String? = null
    var partida: PartidaResponse? = null
    var tipoApostaEnum: TipoApostaEnum? = null
    var valor: Double? = null
    private var odd: Double? = null
    var possivelRetorno: String? = null

    constructor(id: Long?, usuario: String?, partida: PartidaResponse?,
                tipoApostaEnum: TipoApostaEnum?, valor: Double?, odd: Double?, possivelRetorno: String?) {
        this.id = id
        this.usuario = usuario
        this.partida = partida
        this.tipoApostaEnum = tipoApostaEnum
        this.valor = valor
        this.odd = odd
        this.possivelRetorno = possivelRetorno
    }

    constructor() {}

    fun getOdd(): String {
        return df2.format(odd)
    }

    fun setOdd(odd: Double?) {
        this.odd = odd
    }

    companion object {
        private val df = DecimalFormat("R$ 0.00")
        private val df2 = DecimalFormat("0.00")
        fun toApostaResponse(aposta: Aposta): ApostaResponse {
            val partidaResponse = PartidaResponse()
            partidaResponse.resultado = aposta.partida!!.resultado
            partidaResponse.dataHora = aposta.partida!!.dataHora
            partidaResponse.timeCasa = aposta.partida!!.timeCasa!!.nome
            partidaResponse.timeVisitante = aposta.partida!!.timeVisitante!!.nome
            return ApostaResponse(
                    aposta.id,
                    aposta.usuario.getNome(),
                    partidaResponse,
                    aposta.tipo,
                    aposta.valorApostado,
                    aposta.odd,
                    df.format(aposta.odd * aposta.valorApostado!!)
            )
        }
    }
}


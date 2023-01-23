package br.com.g1bet.service

import br.com.g1bet.dto.request.ApostaRequest
import br.com.g1bet.dto.response.ApostaResponse
import br.com.g1bet.mapper.exceptions.SaldoInsuficienteException
import br.com.g1bet.model.Aposta
import br.com.g1bet.model.TipoApostaEnum
import br.com.g1bet.repository.ApostaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.function.Function

@Service
class ApostaService(private val repository: ApostaRepository, private val usuarioService: UsuarioService, private val partidaService: PartidaService) {
    fun buscarId(id: Long): ResponseEntity<ApostaResponse> {
        return repository.findById(id)
                .map { resp -> ResponseEntity.ok(ApostaResponse.toApostaResponse(resp)) }
                .orElse(ResponseEntity.notFound().build())
    }

    fun buscarTipo(tipoDeAposta: TipoApostaEnum?): List<Aposta?>? {
        return repository.findAllByTipo(tipoDeAposta)
    }

    fun apostar(apostaRequest: ApostaRequest): ApostaResponse {
        val usuario = usuarioService.buscar(apostaRequest.usuario)
        if (usuario.getSaldoUsuario() < apostaRequest.valorApostado) {
            throw SaldoInsuficienteException("Saldo insuficiente")
        }
        val partida = partidaService.findById(apostaRequest.partida)
        var aposta = Aposta()
        aposta.tipo = apostaRequest.tipo
        aposta.usuario = usuario
        aposta.partida = partida
        aposta.valorApostado = apostaRequest.valorApostado
        aposta = repository.save(aposta)
        return ApostaResponse.toApostaResponse(aposta)
    }

    fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    fun exibirHistorico(id: Long?): List<ApostaResponse> {
        return repository.findByUsuarioId(id)!!.stream().map<ApostaResponse>(Function { aposta: Aposta? -> ApostaResponse.toApostaResponse(aposta) }).toList()
    }
}
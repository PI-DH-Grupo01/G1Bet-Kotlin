package br.com.g1bet.service

import br.com.g1bet.mapper.exceptions.IdNaoExisteException
import br.com.g1bet.model.Partida
import br.com.g1bet.repository.PartidaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PartidaService {
    @Autowired
    private val repository: PartidaRepository? = null
    fun exibirHistoricoPartida(idTime: Long?): List<Partida?>? {
        val visitantes = repository!!.findAllByTimeVisitante_Id(idTime)
        val casa = repository.findAllByTimeCasa_Id(idTime)
        visitantes.addAll(casa)
        return visitantes
    }

    fun findById(id: Long): Partida {
        return repository!!.findById(id)
                .orElseThrow { IllegalArgumentException("Partida não encontrada") }!!
    }

    fun cadastrar(partida: Partida): Partida {
        return repository!!.save(partida)
    }

    fun deletar(id: Long) {
        val partida = repository!!.findById(id)
        if (!partida.isPresent) {
            throw IdNaoExisteException("Id não encontrado")
        }
        repository.deleteById(id)
    }
}
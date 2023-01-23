package br.com.g1bet.service

import br.com.g1bet.mapper.exceptions.CampoExistenteException
import br.com.g1bet.mapper.exceptions.IdNaoExisteException
import br.com.g1bet.model.Time
import br.com.g1bet.repository.TimeRepository
import org.hibernate.ObjectNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TimeService(private val timeRepository: TimeRepository) {
    fun buscarTodosTimes(): List<Time?> {
        return timeRepository.findAll()
    }

    fun buscarId(id: Long): Time {
        return timeRepository.findById(id)
                .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }!!
    }

    fun cadastrar(time: Time): Time {
        if (timeRepository.existsByNome(time.nome)!!) {
            throw CampoExistenteException("Esse time já está cadastrado")
        }
        return timeRepository.save(time)
    }

    fun findById(id: Long): Time {
        return timeRepository.findById(id)
                .orElseThrow { ObjectNotFoundException("Id $id", "Time não encontrado") }!!
    }

    fun atualizar(time: Time, id: Long): Time {
        val atualizar = findById(id)
        atualizar.nome = time.nome
        return timeRepository.save(atualizar)
    }

    fun deletar(id: Long) {
        val time = timeRepository.findById(id)
        if (time.isPresent) {
            timeRepository.deleteById(id)
        }
        time.orElseThrow { IdNaoExisteException("Id nao existe") }
    }
}
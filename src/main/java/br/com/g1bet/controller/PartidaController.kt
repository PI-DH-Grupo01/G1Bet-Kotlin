package br.com.g1bet.controller

import br.com.g1bet.model.Partida
import br.com.g1bet.repository.PartidaRepository
import br.com.g1bet.service.PartidaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partida")
@CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
class PartidaController {
    @Autowired
    private val service: PartidaService? = null

    @Autowired
    private val repository: PartidaRepository? = null
    @GetMapping("/historico/{idTime}")
    fun exibirHistoricoPartida(@PathVariable idTime: Long?): ResponseEntity<List<Partida>> {
        return ResponseEntity.ok(service!!.exibirHistoricoPartida(idTime))
    }

    @PostMapping
    fun cadastrar(@RequestBody partida: Partida?): ResponseEntity<Partida> {
        return ResponseEntity.ok(service!!.cadastrar(partida))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long?) {
        service?.deletar(id)
    }

    @PutMapping
    fun put(@RequestBody partidaModel: Partida?): ResponseEntity<Partida> {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(partidaModel))
    }
}
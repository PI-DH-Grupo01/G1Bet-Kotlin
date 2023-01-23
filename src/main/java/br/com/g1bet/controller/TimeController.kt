package br.com.g1bet.controller

import br.com.g1bet.model.Time
import br.com.g1bet.service.TimeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/times")
@CrossOrigin("*")
class TimeController(timeService: TimeService) {
    private val timeService: TimeService

    init {
        this.timeService = timeService
    }

    @GetMapping
    fun buscarTodosTimes(): ResponseEntity<List<Time>> {
        return ResponseEntity.ok(timeService.buscarTodosTimes())
    }

    @GetMapping("/{id}")
    fun buscarId(@PathVariable id: Long?): ResponseEntity<Time> {
        return ResponseEntity.ok(timeService.buscarId(id))
    }

    //    @GetMapping("/{time}")
    //    public ResponseEntity<List<Time>> getByTime(@PathVariable String nome) {
    //        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    //    }
    @PostMapping
    fun post(@RequestBody time: Time?): ResponseEntity<Time> {
        return ResponseEntity.status(HttpStatus.CREATED).body(timeService.cadastrar(time))
    }

    @PutMapping
    fun put(@RequestBody time: Time?, id: Long?): ResponseEntity<Time> {
        return ResponseEntity.status(HttpStatus.OK).body(timeService.atualizar(time, id))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long?) {
        timeService.deletar(id)
    }
}
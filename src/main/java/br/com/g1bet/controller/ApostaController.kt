

package br.com.g1bet.controller

import br.com.g1bet.dto.request.ApostaRequest
import br.com.g1bet.dto.response.ApostaResponse
import br.com.g1bet.model.Aposta
import br.com.g1bet.model.TipoApostaEnum
import br.com.g1bet.service.ApostaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apostas")
@CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
class ApostaController(apostaService: ApostaService) {
    private val service: ApostaService

    init {
        service = apostaService
    }

    //    @GetMapping
    //    public ResponseEntity<List<Aposta>> getAll() {
    //        return (ResponseEntity<List<Aposta>>) service.findAll();
    //    }
    @GetMapping("/{id}")
    fun buscarId(@PathVariable id: Long?): ResponseEntity<ApostaResponse> {
        return service.buscarId(id)
    }

    @GetMapping("/tipo/{tipoDeAposta}")
    fun buscarTipo(@PathVariable tipoDeAposta: TipoApostaEnum?): ResponseEntity<List<Aposta>> {
        return ResponseEntity.ok(service.buscarTipo(tipoDeAposta))
    }

    @PostMapping
    fun apostar(@RequestBody apostaModel: ApostaRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.apostar(apostaModel))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long?) {
        service.deleteById(id)
    }

    @GetMapping("/historico/{id}")
    fun exibirHistorico(@PathVariable id: Long?): ResponseEntity<List<ApostaResponse>> {
        return ResponseEntity.ok(service.exibirHistorico(id))
    }
}
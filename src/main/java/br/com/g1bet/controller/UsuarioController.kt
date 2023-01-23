package br.com.g1bet.controller

import br.com.g1bet.dto.request.UsuarioRequest
import br.com.g1bet.dto.response.UsuarioResponse
import br.com.g1bet.model.Usuario
import br.com.g1bet.service.UsuarioService
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
@RequiredArgsConstructor
class UsuarioController {
    private val service: UsuarioService? = null
    @PostMapping
    fun cadastrar(@RequestBody usuarioRequest: UsuarioRequest?): ResponseEntity<UsuarioResponse> {
        return ResponseEntity.ok(service!!.cadastrar(usuarioRequest))
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long?): ResponseEntity<Void> {
        service!!.deletar(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/atualizar/{id}")
    fun atualizar(@RequestBody usuario: Usuario?, @PathVariable id: Long?): ResponseEntity<Usuario> {
        return ResponseEntity.ok().body(service!!.atualizar(usuario, id))
    }
}
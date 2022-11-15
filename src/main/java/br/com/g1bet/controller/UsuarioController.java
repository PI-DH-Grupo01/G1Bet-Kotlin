package br.com.g1bet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	private final UsuarioService service;

	public UsuarioController(UsuarioService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(service.cadastrar(usuario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	

}

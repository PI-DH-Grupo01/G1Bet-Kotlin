package br.com.g1bet.service;

import org.springframework.stereotype.Service;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Usuario cadastrar(Usuario usuario) {
		return repository.save(usuario);
	}

}

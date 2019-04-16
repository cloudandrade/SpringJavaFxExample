package com.springexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.model.Usuario;
import com.springexample.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void excluir(Usuario usuario) {

		usuarioRepository.delete(usuario);
	}

	public List<Usuario> buscarTodos() {
		return usuarioRepository.buscarTodos();
	}
	
	public Usuario buscarPorId(int id){
		return usuarioRepository.findById(id);
	}

	
	
}

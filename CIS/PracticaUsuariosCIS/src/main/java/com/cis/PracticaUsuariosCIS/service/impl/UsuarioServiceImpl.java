package com.cis.PracticaUsuariosCIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cis.PracticaUsuariosCIS.model.Usuario;
import com.cis.PracticaUsuariosCIS.repository.UsuarioRepository;
import com.cis.PracticaUsuariosCIS.service.UsuarioService;

@Component
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> getAllUsuarios() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(int id) {

		return this.usuarioRepository.getOne(id);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public void removeUsuario(Usuario usuario) {
		this.usuarioRepository.delete(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {

		usuario.setId(usuario.getId());
		usuario.setNombre(usuario.getNombre());
		usuario.setApellido(usuario.getApellido());
		usuario.setUsername(usuario.getUsername());
		usuario.setPassword(usuario.getPassword());
		return this.usuarioRepository.save(usuario);
	}


	
}

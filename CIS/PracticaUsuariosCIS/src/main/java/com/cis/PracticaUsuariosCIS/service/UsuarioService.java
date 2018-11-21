package com.cis.PracticaUsuariosCIS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cis.PracticaUsuariosCIS.model.Usuario;

@Service
public interface UsuarioService {
	
	public List<Usuario> getAllUsuarios();

	public Usuario getUsuarioById(int id);

	public Usuario saveUsuario(Usuario usuario);

	public void removeUsuario(Usuario usuario);

	public Usuario updateUsuario(Usuario usuario);

}

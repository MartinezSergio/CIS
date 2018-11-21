package com.cis.PracticaUsuariosCIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.PracticaUsuariosCIS.model.Usuario;
import com.cis.PracticaUsuariosCIS.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>>getAllUsuario() {
		return new ResponseEntity<List<Usuario>>(usuarioService.getAllUsuarios(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getToDoById(@PathVariable("id") int id) {
		Usuario s = this.usuarioService.getUsuarioById(id);
		if (s == null) {
			return new ResponseEntity<Usuario>(s, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Usuario>(s, HttpStatus.OK);
		}

	}	

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<Usuario> saveToDo(@RequestBody Usuario usuario) {
		System.out.println("Holaaaaaa");
		return new ResponseEntity<Usuario>(usuarioService.saveUsuario(usuario), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateToDo(@RequestBody Usuario usuario) {
		boolean correcto = true;
		RequestEntity<Usuario> respuesta;

		if (usuario == null) {
			correcto = false;
			return new ResponseEntity<Usuario>(usuarioService.saveUsuario(usuario), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Usuario>(usuarioService.saveUsuario(usuario), HttpStatus.ACCEPTED);
		}

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeToDoById(@PathVariable("id") int id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		usuarioService.removeUsuario(usuario);
		return new ResponseEntity<String>("Usuario eliminado", HttpStatus.OK);
	}
	

}

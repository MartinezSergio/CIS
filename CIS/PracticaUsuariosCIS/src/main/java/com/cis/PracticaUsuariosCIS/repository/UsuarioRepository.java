package com.cis.PracticaUsuariosCIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cis.PracticaUsuariosCIS.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

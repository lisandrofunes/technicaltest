package com.dux.technicaltest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dux.technicaltest.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByUsername(String string);
    
}

package com.dux.technicaltest.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dux.technicaltest.entity.Usuario;
import com.dux.technicaltest.repository.UsuarioRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        if (usuarioRepository.findByUsername("test").isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setUsername("test");
            usuario.setPassword(encoder.encode("12345"));
            usuarioRepository.save(usuario);
        }
    }
}
package com.example.apitreeeco.services;

import com.example.apitreeeco.entities.Usuario;
import org.springframework.stereotype.Service;

public interface IUsuarioService {
    public Usuario findByUsername(String username);
    public Usuario registrar(Usuario usuario);
}

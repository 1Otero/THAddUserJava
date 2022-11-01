package com.example.thcidenet.service;

import com.example.thcidenet.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listUser();
    Usuario user(long Id);
    Usuario updateUser(Usuario user);
    Usuario CreateUser(Usuario user);
    int correosMatch(String correo, Long id);
    String delete(Long Id);
}

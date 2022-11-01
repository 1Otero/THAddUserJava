package com.example.thcidenet.service;

import com.example.thcidenet.modelo.Registro;
import com.example.thcidenet.modelo.Usuario;

import java.util.List;

public interface IRegistroService {
    List<Registro> listRegistro();
    Registro registro(long Id);
    Registro updateRegistro(Registro registro);
    Registro CreateRegistro(Registro registro);
}

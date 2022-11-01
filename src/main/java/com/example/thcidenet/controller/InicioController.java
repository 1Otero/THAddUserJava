package com.example.thcidenet.controller;

import com.example.thcidenet.modelo.Registro;
import com.example.thcidenet.modelo.Usuario;
import com.example.thcidenet.modelo.validar;
import com.example.thcidenet.service.RegistroService;
import com.example.thcidenet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE})
public class InicioController {

    @Autowired
    private UsuarioService usuario;
    @Autowired
    private RegistroService registro;

    @PostMapping("/add")
    public Usuario createUsuario(@RequestBody Usuario usuario1){
        Usuario usu = this.usuario.CreateUser(usuario1);
        return usu;
    }
    @GetMapping("/")
    public List<Usuario> getUsuarios(){
        List<Usuario> list = this.usuario.listUser();
        return list;
    }
    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@RequestParam(name = "id", defaultValue = "1") int Id){
        Usuario list = this.usuario.user(Id);
        String[] s = {"",""};
        return list;
    }
    @PostMapping("/update")
    public Usuario update(@RequestBody Usuario cli){
        Usuario usuario1 = this.usuario.updateUser(cli);
        return usuario1;
    }
    @PostMapping("/validarcorreo")
    public int getCorreos(@RequestBody validar valida){
        var count = this.usuario.correosMatch(valida.getCorreo(), valida.getId());
        return count;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@RequestParam(value = "id", defaultValue = "1") Long Id){
        return this.usuario.delete(Id);
    }
}

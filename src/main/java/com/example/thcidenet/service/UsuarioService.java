package com.example.thcidenet.service;

import com.example.thcidenet.modelo.Registro;
import com.example.thcidenet.modelo.Usuario;
import com.example.thcidenet.repository.IRegistroRepository;
import com.example.thcidenet.repository.IUsuarioRepository;
import com.example.thcidenet.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{
    public UsuarioService(){

    }
    @Autowired
    private IUsuarioRepository usuario;
    @Autowired
    private IRegistroRepository registro;

    @Override
    public List<Usuario> listUser() {
        List<Usuario> lUsuario = this.usuario.findAll();
        return lUsuario;
    }
    @Override
    public Usuario user(long Id) {
        Usuario User = this.usuario.findById(Id).get();
        return User;
    }

    @Override
    public Usuario updateUser(Usuario user) {
            var cli = this.usuario.findById(user.getId()).get();
        System.out.println("Registro reporte usuario: ");
        System.out.println(cli);
        if (cli != null){
            if(user.getPNombre()!=null){cli.setPNombre(user.getPNombre());}
            if(user.getSNombre()!=null){cli.setSNombre(user.getSNombre());}
            if(user.getPApellido()!=null){cli.setPApellido(user.getPApellido());}
            if(user.getSApellido()!=null){cli.setSApellido(user.getSApellido());}
            //if(user.getRegistro().getId()!=null){cli.getRegistro().setId(cli.getRegistro().getId());}
            if(user.getRegistro().getArea()!=0){cli.getRegistro().setArea(user.getRegistro().getArea());}
            if(user.getPApellido()!=null){cli.getRegistro().setEstado(user.getRegistro().getEstado());}
            if(user.getRegistro().getPaisEmpleo()!=null){cli.getRegistro().setPaisEmpleo(user.getRegistro().getPaisEmpleo());}
            if(user.getRegistro().getCorreoElectronico()!=null){cli.getRegistro().setCorreoElectronico(user.getRegistro().getCorreoElectronico());}
            if(user.getRegistro().getTipoIdentificacion()!=null){cli.getRegistro().setTipoIdentificacion(user.getRegistro().getTipoIdentificacion());}
            if(user.getRegistro().getNumeroIdentificacion()!=0){cli.getRegistro().setNumeroIdentificacion(user.getRegistro().getNumeroIdentificacion());}
            if(user.getRegistro().getInicioIngreso()!=null){cli.getRegistro().setInicioIngreso(user.getRegistro().getInicioIngreso());}
            //if(user.getRegistro().getFechaHoraRegistro()!=null){cli.getRegistro().setFechaHoraRegistro(user.getRegistro().getFechaHoraRegistro());}
            return this.usuario.save(cli);
        }else{
            Usuario u = new Usuario();
            u.setPNombre("Fallo update entro else");
            return u;
        }
    }

    @Override
    public Usuario CreateUser(Usuario user) {
        int[] f = {1, 1};
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Horas y fechas con java ----");
        System.out.println(df);
        Registro registro = new Registro();
        registro.setInicioIngreso(user.getRegistro().getInicioIngreso());
        //registro.setFechaHoraRegistro(user.getRegistro().getFechaHoraRegistro());
        registro.setArea(user.getRegistro().getArea());
        registro.setEstado(user.getRegistro().getEstado());
        registro.setPaisEmpleo(user.getRegistro().getPaisEmpleo());
        registro.setTipoIdentificacion(user.getRegistro().getTipoIdentificacion());
        registro.setNumeroIdentificacion(user.getRegistro().getNumeroIdentificacion());
        registro.setCorreoElectronico(user.getRegistro().getCorreoElectronico());
        Registro registro1 = this.registro.save(registro);
        //Solo el Id
        //user.getRegistro().setId(registro1.getId());
        //Con todo el registro
        user.setRegistro(registro1);
        Usuario user1 = this.usuario.save(user);
        return user1;
    }

    @Override
    public int correosMatch(String correo, Long id) {
        try{
            var i = this.usuario.countCorreos(correo, id);
            return i;
        }catch(Exception e){
            return 0;
        }

    }
    @Override
    public String delete(Long Id) {
        this.usuario.deleteById(Id);
        return "elimino";
    }
}

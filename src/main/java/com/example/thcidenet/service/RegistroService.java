package com.example.thcidenet.service;

import com.example.thcidenet.modelo.Registro;
import com.example.thcidenet.modelo.Usuario;
import com.example.thcidenet.repository.IRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService implements IRegistroService{

    private IRegistroRepository registro;
    @Override
    public List<Registro> listRegistro() {
        return this.registro.findAll();
    }

    @Override
    public Registro registro(long Id) {
        Registro reg = this.registro.findById(Id).get();
        return reg;
    }

    @Override
    public Registro updateRegistro(Registro registro) {
        Registro reg = this.registro.findById(registro.getId()).get();
        if (reg != null){
            if(registro.getEstado() != 0){reg.setEstado(registro.getEstado());}
            if(registro.getArea()!=0){reg.setArea(registro.getArea());}
            //if(registro.getFechaHoraRegistro()!=null){reg.setFechaHoraRegistro(registro.getFechaHoraRegistro());}
            if(registro.getInicioIngreso()!=null){reg.setInicioIngreso(registro.getInicioIngreso());}
            return this.registro.save(reg);
        }else{
            return reg;
        }
    }

    @Override
    public Registro CreateRegistro(Registro registro) {
        return this.registro.save(registro);
    }
}

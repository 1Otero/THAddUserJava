package com.example.thcidenet.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long Id;
    @JsonProperty("InicioIngreso")
    private Date InicioIngreso;
    @JsonProperty("PaisEmpleo")
    private String PaisEmpleo;
    @JsonProperty("TipoIdentificacion")
    private String TipoIdentificacion;
    @JsonProperty("NumeroIdentificacion")
    private int NumeroIdentificacion;
    @JsonProperty("CorreoElectronico")
    private String CorreoElectronico;
    @JsonProperty("Area")
    private int Area;
    @JsonProperty("Estado")
    private int Estado;
    @JsonProperty("FechaHoraRegistro")
    private Date FechaHoraRegistro;
}

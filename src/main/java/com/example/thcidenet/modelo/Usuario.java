package com.example.thcidenet.modelo;

import com.example.thcidenet.modelo.Registro;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long Id;
    @Column(name = "PNombre")
    @JsonProperty("PNombre")
    private String PNombre;
    @JsonProperty("SNombre")
    private String SNombre;
    @JsonProperty("PApellido")
    private String PApellido;
    @JsonProperty("SApellido")
    private String SApellido;
    @JoinColumn(name = "registro_id")
    @ManyToOne
    private Registro registro;
    /*@Transient
    @JsonProperty("registro")
    private Registro registro;*/
}

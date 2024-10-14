package com.lucasferraz.medicalconsult.consulta.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasferraz.medicalconsult.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CONSULTA")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long idConsulta;

    @Column(name = "DATA_CONSULTA")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataConsulta;

    @Column(name = "PROFISSIONAL")
    private String profissional;

    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Consulta() {}
    public Consulta(Long idConsulta, String dataConsulta, String profissional, String especialidade, Usuario usuario) {
        this.idConsulta = idConsulta;
        this.dataConsulta = dataConsulta;
        this.profissional = profissional;
        this.especialidade = especialidade;
        this.usuario = usuario;
    }

}
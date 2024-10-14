package com.lucasferraz.medicalconsult.usuario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasferraz.medicalconsult.usuario.Enum.Permissao;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long IdUsuario;
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "DATA_NASCIMENTO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @Enumerated(EnumType.STRING)

    @Column(name = "PERMISSAO")
    private Permissao permissao;

    public Usuario() {
    }
    public Usuario(Long idUsuario, String nomeUsuario, String email, String cpf, String telefone, Date dataNascimento) {
        IdUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.permissao = permissao;

    }
}
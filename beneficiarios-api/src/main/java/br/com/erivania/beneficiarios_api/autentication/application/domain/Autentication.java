package br.com.erivania.beneficiarios_api.autentication.application.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Autentication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}

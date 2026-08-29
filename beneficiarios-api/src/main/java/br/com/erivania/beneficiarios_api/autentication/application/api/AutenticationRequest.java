package br.com.erivania.beneficiarios_api.autentication.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class AutenticationRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}

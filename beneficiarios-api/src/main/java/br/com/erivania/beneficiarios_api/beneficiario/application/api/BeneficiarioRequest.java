package br.com.erivania.beneficiarios_api.beneficiario.application.api;

import br.com.erivania.beneficiarios_api.documento.application.api.DocumentoRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class BeneficiarioRequest{
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotNull
    private LocalDate dataNascimento;
    private List<@Valid DocumentoRequest> documentos;
}

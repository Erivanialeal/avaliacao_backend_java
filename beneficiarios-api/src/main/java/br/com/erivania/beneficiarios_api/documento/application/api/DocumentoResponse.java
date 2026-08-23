package br.com.erivania.beneficiarios_api.documento.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class DocumentoResponse {
    @NotBlank
    private  String tipoDocumento;
    @NotBlank
    private String descricao;

}

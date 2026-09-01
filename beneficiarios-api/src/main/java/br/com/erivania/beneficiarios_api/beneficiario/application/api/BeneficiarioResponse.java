package br.com.erivania.beneficiarios_api.beneficiario.application.api;
import br.com.erivania.beneficiarios_api.documento.application.api.DocumentoResponse;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class BeneficiarioResponse {
    private UUID idBeneficiario;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private List<DocumentoResponse> documentos;
}

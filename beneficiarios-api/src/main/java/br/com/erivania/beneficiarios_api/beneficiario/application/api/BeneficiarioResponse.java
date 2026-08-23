package br.com.erivania.beneficiarios_api.beneficiario.application.api;
import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class BeneficiarioResponse {
    private UUID idBeneficiario;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
}

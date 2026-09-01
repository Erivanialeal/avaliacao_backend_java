package br.com.erivania.beneficiarios_api.beneficiario.application.api;

import br.com.erivania.beneficiarios_api.beneficiario.domain.Beneficiario;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class BeneficiarioListResponse {
    private UUID idBeneficiario;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;

    public BeneficiarioListResponse(Beneficiario beneficiario) {
        this.idBeneficiario = beneficiario.getIdBeneficiario();
        this.nome = beneficiario.getNome();
        this.telefone = beneficiario.getTelefone();
        this.dataNascimento = beneficiario.getDataNascimento();
    }

    public static List<BeneficiarioListResponse> converte(List<Beneficiario> beneficiarios) {
        return beneficiarios.stream()
                .map(p -> new BeneficiarioListResponse(p))
                .collect(Collectors.toList());
    }
}

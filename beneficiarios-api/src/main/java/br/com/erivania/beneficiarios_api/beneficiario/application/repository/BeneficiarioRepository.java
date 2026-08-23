package br.com.erivania.beneficiarios_api.beneficiario.application.repository;

import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;

public interface BeneficiarioRepository {
    Beneficiario salva(Beneficiario beneficiario);
}

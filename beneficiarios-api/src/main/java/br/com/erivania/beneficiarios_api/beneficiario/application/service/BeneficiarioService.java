package br.com.erivania.beneficiarios_api.beneficiario.application.service;

import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioRequest;
import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioResponse;

public interface BeneficiarioService {
    BeneficiarioResponse criarBeneficiario(BeneficiarioRequest beneficiarioRequest);
}

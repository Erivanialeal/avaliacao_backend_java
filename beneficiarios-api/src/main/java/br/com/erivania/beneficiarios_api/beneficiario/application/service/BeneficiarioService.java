package br.com.erivania.beneficiarios_api.beneficiario.application.service;

import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioListResponse;
import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioRequest;
import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioResponse;

import java.util.List;

public interface BeneficiarioService {
    BeneficiarioResponse criarBeneficiario(BeneficiarioRequest beneficiarioRequest);
    List<BeneficiarioListResponse> listarTodosOsBeneficiario();
}

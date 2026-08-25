package br.com.erivania.beneficiarios_api.beneficiario.application.service;

import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioListResponse;
import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioRequest;
import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioResponse;
import br.com.erivania.beneficiarios_api.documento.application.api.DocumentoResponse;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioService {
    BeneficiarioResponse criarBeneficiario(BeneficiarioRequest beneficiarioRequest);
    List<BeneficiarioListResponse> listarTodosOsBeneficiario();
    List<DocumentoResponse> listarTodosOsDocumentos(UUID idBeneficiario);
    BeneficiarioResponse atualizar(UUID idBeneficiario, BeneficiarioRequest request);
}

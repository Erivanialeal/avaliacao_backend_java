package br.com.erivania.beneficiarios_api.beneficiario.repository;

import br.com.erivania.beneficiarios_api.beneficiario.domain.Beneficiario;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioRepository {
    Beneficiario salva(Beneficiario beneficiario);
    List<Beneficiario> findAll();
    Beneficiario buscarId(UUID idBeneficiario);
    Beneficiario delete(UUID idBeneficiario);
}

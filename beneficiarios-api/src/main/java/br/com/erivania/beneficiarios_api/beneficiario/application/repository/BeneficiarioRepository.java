package br.com.erivania.beneficiarios_api.beneficiario.application.repository;

import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;

import java.util.List;

public interface BeneficiarioRepository {
    Beneficiario salva(Beneficiario beneficiario);
    List<Beneficiario> findAll();
}

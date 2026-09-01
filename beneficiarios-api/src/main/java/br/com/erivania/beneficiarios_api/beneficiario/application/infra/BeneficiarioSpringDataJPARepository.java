package br.com.erivania.beneficiarios_api.beneficiario.application.infra;

import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeneficiarioSpringDataJPARepository extends JpaRepository<Beneficiario, UUID> {
    Beneficiario findByIdBeneficiario(UUID idBeneficiario);
}

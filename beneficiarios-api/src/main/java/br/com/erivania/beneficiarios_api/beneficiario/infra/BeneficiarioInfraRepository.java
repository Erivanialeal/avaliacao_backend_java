package br.com.erivania.beneficiarios_api.beneficiario.infra;

import br.com.erivania.beneficiarios_api.beneficiario.domain.Beneficiario;
import br.com.erivania.beneficiarios_api.beneficiario.repository.BeneficiarioRepository;
import br.com.erivania.beneficiarios_api.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class BeneficiarioInfraRepository implements BeneficiarioRepository {
    private final  BeneficiarioSpringDataJPARepository beneficiarioSpringDataJPARepository;

    @Override
    public Beneficiario salva(Beneficiario beneficiario) {
        log.info("[inicia] BeneficiarioInfraRepository - salva");
        beneficiarioSpringDataJPARepository.save(beneficiario);
        log.info("[finaliza] BeneficiarioInfraRepository - salva");

        return beneficiario;
    }

    @Override
    public List<Beneficiario> findAll() {
        log.info("[inicia] BeneficiarioInfraRepository - findAll");
        List<Beneficiario> listaTodosBeneficiario = beneficiarioSpringDataJPARepository.findAll();
        log.info("[finaliza] BeneficiarioInfraRepository - findAll");
        return listaTodosBeneficiario;
    }

    @Override
    public Beneficiario buscarId(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioInfraRepository - buscarId");
        Beneficiario beneficiario = beneficiarioSpringDataJPARepository.findByIdBeneficiario(idBeneficiario);
        log.info("[inicia] BeneficiarioInfraRepository - buscarId");
        return beneficiario;
    }

    @Override
    public Beneficiario delete(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioInfraRepository -  delete");
        Beneficiario beneficiario= beneficiarioSpringDataJPARepository.findById(idBeneficiario)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Usuário não encontrado!"));
        beneficiarioSpringDataJPARepository.delete(beneficiario);
        log.info("[inicia] BeneficiarioInfraRepository -  delete");
        return beneficiario;
    }


}

package br.com.erivania.beneficiarios_api.beneficiario.application.service;

import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioRequest;
import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioResponse;
import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;
import br.com.erivania.beneficiarios_api.beneficiario.application.repository.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BeneficiarioApplicationService implements BeneficiarioService {
    private final BeneficiarioRepository beneficiarioRepository;
    @Override
    public BeneficiarioResponse criarBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia] BeneficiarioApplicationService - criarBeneficiario ");
        Beneficiario beneficiario = beneficiarioRepository.salva(new Beneficiario(beneficiarioRequest));
        log.info("[inicia] BeneficiarioApplicationService - criarBeneficiario ");
        return BeneficiarioResponse.builder()
                .idBeneficiario(beneficiario.getIdBeneficiario())
                .nome(beneficiario.getNome())
                .telefone(beneficiario.getTelefone())
                .dataNascimento(beneficiario.getDataNascimento())
                .build();
    }
}

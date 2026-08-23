package br.com.erivania.beneficiarios_api.beneficiario.application.api;

import br.com.erivania.beneficiarios_api.beneficiario.application.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class BeneficiarioCotroller implements BeneficiarioAPI {
    private  final BeneficiarioService beneficiarioService;

    @Override
    public BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia] BeneficiarioCotroller - postBeneficiario");
        BeneficiarioResponse beneficiarioCriado = beneficiarioService.criarBeneficiario(beneficiarioRequest);
        log.info("[finaliza] BeneficiarioCotroller - postBeneficiario");
        return beneficiarioCriado;
    }
}

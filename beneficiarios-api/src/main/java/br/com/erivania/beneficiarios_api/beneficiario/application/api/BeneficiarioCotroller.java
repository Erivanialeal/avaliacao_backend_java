package br.com.erivania.beneficiarios_api.beneficiario.application.api;

import br.com.erivania.beneficiarios_api.beneficiario.application.service.BeneficiarioService;
import br.com.erivania.beneficiarios_api.documento.application.api.DocumentoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<BeneficiarioListResponse> getListaTodosBeneficiarios() {
        log.info("[inicia] BeneficiarioCotroller - getListaTodosBeneficiarios");
        List<BeneficiarioListResponse> beneficiario = beneficiarioService.listarTodosOsBeneficiario();
        log.info("[finaliza] BeneficiarioCotroller - getListaTodosBeneficiarios");
        return beneficiario;
    }

    @Override
    public List<DocumentoResponse> getListaDocumentosBeneficiario(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioCotroller - getListaDocumentosBeneficiario");
        List<DocumentoResponse> documentos = beneficiarioService.listarTodosOsDocumentos(idBeneficiario);
        log.info("[finaliza] BeneficiarioCotroller - getListaDocumentosBeneficiario");
        return documentos;
    }

    @Override
    public BeneficiarioListResponse patchAtualizarBeneficiario(UUID idBeneficiario, BeneficiarioRequest request) {
        log.info("[inicia] BeneficiarioCotroller - patchAtualizarBeneficiario");
        BeneficiarioListResponse response = beneficiarioService.atualizar(idBeneficiario,request);
        log.info("[finaliza] BeneficiarioCotroller - patchAtualizarBeneficiario");
        return response;
    }

    @Override
    public BeneficiarioListResponse deleteBeneficiario(UUID idBeneficiario) {
        BeneficiarioListResponse deletar = beneficiarioService.deletarBeneficiario(idBeneficiario);
        return deletar;
    }
}

package br.com.erivania.beneficiarios_api.beneficiario.application.service;

import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioRequest;
import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioResponse;
import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;
import br.com.erivania.beneficiarios_api.beneficiario.application.repository.BeneficiarioRepository;
import br.com.erivania.beneficiarios_api.documento.application.api.DocumentoResponse;
import br.com.erivania.beneficiarios_api.documento.application.domain.Documento;
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
        Beneficiario beneficiario = new Beneficiario(beneficiarioRequest);
        beneficiarioRequest.getDocumentos().forEach(documentoRequest -> {
            Documento documento = new Documento(documentoRequest, beneficiario);
            beneficiario.adicionarDocumento(documento);
        });
        beneficiarioRepository.salva(beneficiario);
        log.info("[finaliza] BeneficiarioApplicationService - criarBeneficiario ");
        return BeneficiarioResponse.builder()
                .idBeneficiario(beneficiario.getIdBeneficiario())
                .nome(beneficiario.getNome())
                .telefone(beneficiario.getTelefone())
                .dataNascimento(beneficiario.getDataNascimento())
                .documentos(
                    beneficiario.getDocumentos()
                            .stream()
                            .map(documento -> new DocumentoResponse(
                                    documento.getTipoDocumento(),
                                    documento.getDescricao()
                            ))
                            .toList()
                )
                .build();
    }
}

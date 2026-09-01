package br.com.erivania.beneficiarios_api.beneficiario.application.api;

import br.com.erivania.beneficiarios_api.documento.application.api.DocumentoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/beneficiario")
public interface BeneficiarioAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    BeneficiarioResponse postBeneficiario(@Valid @RequestBody BeneficiarioRequest beneficiarioRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<BeneficiarioListResponse> getListaTodosBeneficiarios();

    @GetMapping("/{idBeneficiario}/documentos")
    List<DocumentoResponse> getListaDocumentosBeneficiario(@PathVariable UUID idBeneficiario);

    @PatchMapping("/{idBeneficiario}")
    BeneficiarioListResponse patchAtualizarBeneficiario(@PathVariable UUID idBeneficiario, @RequestBody BeneficiarioRequest request);

    @DeleteMapping("/{idBeneficiario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    BeneficiarioListResponse deleteBeneficiario(@PathVariable UUID idBeneficiario);








}

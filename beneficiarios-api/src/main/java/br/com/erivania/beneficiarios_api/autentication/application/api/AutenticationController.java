package br.com.erivania.beneficiarios_api.autentication.application.api;

import br.com.erivania.beneficiarios_api.autentication.application.service.AuthenticationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class AutenticationController implements AuthenticationAPI {

    private final AuthenticationService authenticationService;

    public AutenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public AuthenticationResponse authenticationResponse(AuthenticationRequest authenticationRequest) {
        log.info("[inicia] AuthenticationController - authenticationResponse");
        log.info("[inicia] AuthenticationController - authenticationResponse");

        return authenticationService.autentica(authenticationRequest);
    }
}

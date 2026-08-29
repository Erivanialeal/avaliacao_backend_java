package br.com.erivania.beneficiarios_api.autentication.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class AutenticationController implements AutenticationAPI {
    @Override
    public AutenticationResponse autenticationResponse(AutenticationRequest autenticationRequest) {
        log.info("[inicia] AutenticationController - autenticationResponse");
        log.info("[inicia] AutenticationController - autenticationResponse");

        return new AutenticationResponse("teste");
    }
}

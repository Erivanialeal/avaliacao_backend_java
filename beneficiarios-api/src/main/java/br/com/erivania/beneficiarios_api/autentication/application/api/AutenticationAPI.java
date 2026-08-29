package br.com.erivania.beneficiarios_api.autentication.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public interface AutenticationAPI {

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    AutenticationResponse autenticationResponse(@Valid @RequestBody AutenticationRequest autenticationRequest);
}

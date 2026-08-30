package br.com.erivania.beneficiarios_api.autentication.application.service;

import br.com.erivania.beneficiarios_api.autentication.application.api.AuthenticationRequest;
import br.com.erivania.beneficiarios_api.autentication.application.api.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse autentica(AuthenticationRequest request);
}

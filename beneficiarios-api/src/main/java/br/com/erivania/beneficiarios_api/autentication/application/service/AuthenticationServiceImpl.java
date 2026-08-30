package br.com.erivania.beneficiarios_api.autentication.application.service;

import br.com.erivania.beneficiarios_api.autentication.application.api.AuthenticationRequest;
import br.com.erivania.beneficiarios_api.autentication.application.api.AuthenticationResponse;
import br.com.erivania.beneficiarios_api.autentication.application.domain.Authentication;
import br.com.erivania.beneficiarios_api.autentication.application.infra.AuthenticationInfraRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl  implements AuthenticationService{
    private final AuthenticationInfraRepository authenticationInfraRepository;

    public AuthenticationServiceImpl(AuthenticationInfraRepository authenticationInfraRepository) {
        this.authenticationInfraRepository = authenticationInfraRepository;
    }

    @Override
    public AuthenticationResponse autentica(AuthenticationRequest request){
        Authentication authentication =
                authenticationInfraRepository.buscaPorUsername(request.getUsername())
                        .orElseThrow();
        System.out.println("USUARIO ENCONTRADO: " + authentication.getUsername());

        if (!authentication.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }
        return new AuthenticationResponse("teste");
    }
}

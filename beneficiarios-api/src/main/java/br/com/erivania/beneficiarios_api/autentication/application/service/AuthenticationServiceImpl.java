package br.com.erivania.beneficiarios_api.autentication.application.service;

import br.com.erivania.beneficiarios_api.autentication.application.api.AuthenticationRequest;
import br.com.erivania.beneficiarios_api.autentication.application.api.AuthenticationResponse;
import br.com.erivania.beneficiarios_api.autentication.application.domain.Authentication;
import br.com.erivania.beneficiarios_api.autentication.application.infra.AuthenticationInfraRepository;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ConcreteTypeMunger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl  implements AuthenticationService{
    private final AuthenticationInfraRepository authenticationInfraRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationServiceImpl(AuthenticationInfraRepository authenticationInfraRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.authenticationInfraRepository = authenticationInfraRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthenticationResponse autentica(AuthenticationRequest request){
        Authentication authentication =
                authenticationInfraRepository.buscaPorUsername(request.getUsername())
                        .orElseThrow(() -> new RuntimeException("Usúario não encontrado!"));
        System.out.println("USUÁRIO ENCONTRADO: " + authentication.getUsername());
        System.out.println("ID: " + authentication.getIdUsuario());
        System.out.println("PASSWORD: " + authentication.getPassword());
        String token = jwtService.geraToken(authentication);

        if(!passwordEncoder.matches(
                request.getPassword(),
                authentication.getPassword())){
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        return new AuthenticationResponse(token);
    }
}

package br.com.erivania.beneficiarios_api.autentication.application.infra;

import br.com.erivania.beneficiarios_api.autentication.application.domain.Authentication;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface AuthenticationInfraRepository {
    Optional<Authentication> buscaPorUsername(String username);
}

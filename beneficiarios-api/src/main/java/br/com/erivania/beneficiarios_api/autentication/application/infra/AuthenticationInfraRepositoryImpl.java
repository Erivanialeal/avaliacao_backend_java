package br.com.erivania.beneficiarios_api.autentication.application.infra;

import br.com.erivania.beneficiarios_api.autentication.application.domain.Authentication;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class AuthenticationInfraRepositoryImpl implements AuthenticationInfraRepository{
    private final AuthenticationSpringDataJPARepository repository;

    public AuthenticationInfraRepositoryImpl(
            AuthenticationSpringDataJPARepository repository) {
        this.repository = repository;
    }
    @Override
    public Optional<Authentication> buscaPorUsername(String username) {
        return repository.findByUsername(username);
    }
}

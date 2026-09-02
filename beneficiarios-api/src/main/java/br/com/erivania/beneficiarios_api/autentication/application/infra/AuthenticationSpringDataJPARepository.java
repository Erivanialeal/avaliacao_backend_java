package br.com.erivania.beneficiarios_api.autentication.application.infra;

import br.com.erivania.beneficiarios_api.autentication.application.domain.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthenticationSpringDataJPARepository extends JpaRepository<Authentication, UUID> {

    Optional<Authentication> findByUsername(String username);
}

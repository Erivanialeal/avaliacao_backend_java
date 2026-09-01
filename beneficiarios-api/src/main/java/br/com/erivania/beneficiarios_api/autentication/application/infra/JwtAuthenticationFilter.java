package br.com.erivania.beneficiarios_api.autentication.application.infra;

import br.com.erivania.beneficiarios_api.autentication.application.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorizationHeader.substring(7);

        try{
        System.out.println("TOKEN RECEBIDO: " + token);
        String username = jwtService.getUsername(token);
        String role = jwtService.getRole(token);
        System.out.println("USUÁRIO DO TOKEN: " + username);
        System.out.println("ROLE DO TOKEN: " + role);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        List.of(new SimpleGrantedAuthority(role))
                );
        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

    } catch (Exception e) {

        System.out.println("TOKEN INVÁLIDO: " + e.getMessage());
    }

        filterChain.doFilter(request, response);
    }
}

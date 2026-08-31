package br.com.erivania.beneficiarios_api.autentication.application.service;

import br.com.erivania.beneficiarios_api.autentication.application.domain.Authentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    @Value("${spring.jwt.secret}")
    private String secret;

    public String geraToken(Authentication authentication) {

        SecretKey key = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );

        return Jwts.builder()
                .subject(authentication.getUsername())
                .claim("role", authentication.getRole().name())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();
    }
    public  String validaToken(String token){
        SecretKey key =Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}

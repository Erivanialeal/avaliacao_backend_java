package br.com.erivania.beneficiarios_api.autentication.application.infra;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senha = encoder.encode("123456");

        System.out.println(senha);
    }
}

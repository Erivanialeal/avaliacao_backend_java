package br.com.erivania.beneficiarios_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BeneficiariosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiariosApiApplication.class, args);
	}
	@GetMapping("/")
	public String home() {
		return "beneficiario - home";
	}

}

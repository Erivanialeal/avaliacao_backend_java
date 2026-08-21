package br.com.erivania.beneficiarios_api.beneficiario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBeneficio;
    @NotBlank
    private String nome;
    @NotBlank
    private  String telefone;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private LocalDateTime dataInclusao;
    @NotNull
    private LocalDateTime dataAtualizacao;

    public Beneficiario(UUID idBeneficio, String nome, String telefone, LocalDate dataNascimento, LocalDateTime dataInclusao, LocalDateTime dataAtualizacao) {
        this.idBeneficio = idBeneficio;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
    }
}

package br.com.erivania.beneficiarios_api.beneficiario.application.domain;


import br.com.erivania.beneficiarios_api.documento.application.domain.Documento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Beneficiario {
    @Id
    @Column(columnDefinition = "uuid", name = "idBeneficiario",updatable = false, unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBeneficiario;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private LocalDateTime dataInclusao;
    @NotNull
    private LocalDateTime dataAtualizacao;
    @OneToMany(mappedBy = "beneficiario")
    private List<Documento> documentos = new ArrayList<>();

    protected Beneficiario() {
    }

    public Beneficiario(String nome, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }
}

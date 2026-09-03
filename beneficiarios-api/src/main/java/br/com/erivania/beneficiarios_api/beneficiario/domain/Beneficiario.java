package br.com.erivania.beneficiarios_api.beneficiario.domain;


import br.com.erivania.beneficiarios_api.beneficiario.application.api.BeneficiarioRequest;
import br.com.erivania.beneficiarios_api.documento.application.domain.Documento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
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
    @OneToMany(mappedBy = "beneficiario",cascade = CascadeType.ALL)
    private List<Documento> documentos = new ArrayList<>();

    protected Beneficiario() {
    }

    public Beneficiario(BeneficiarioRequest beneficiarioRequest) {
        this.nome = beneficiarioRequest.getNome();
        this.telefone = beneficiarioRequest.getTelefone();
        this.dataNascimento = beneficiarioRequest.getDataNascimento();
        this.dataInclusao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void adicionarDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    public void atualizar(BeneficiarioRequest request) {
        this.nome = request.getNome();
        this.telefone = request.getTelefone();


    }
}

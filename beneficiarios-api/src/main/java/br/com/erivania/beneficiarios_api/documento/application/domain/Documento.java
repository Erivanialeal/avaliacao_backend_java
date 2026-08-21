package br.com.erivania.beneficiarios_api.documento.application.domain;

import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idDocumentos",updatable = false, unique = true,nullable = false)
    private UUID idDocumentos;
    @NotBlank
    private  String tipoDocumento;
    @NotBlank
    private String descricao;
    @NotNull
    private LocalDateTime dataInclusao;
    @NotNull
    private LocalDateTime dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "id_beneficiario")
    private Beneficiario beneficiario;

    protected Documento() {
    }

    public Documento(String tipoDocumento, String descricao) {
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
    }
}

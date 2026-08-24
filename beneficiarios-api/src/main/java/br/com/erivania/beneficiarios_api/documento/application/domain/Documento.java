package br.com.erivania.beneficiarios_api.documento.application.domain;

import br.com.erivania.beneficiarios_api.beneficiario.application.domain.Beneficiario;
import br.com.erivania.beneficiarios_api.documento.application.api.DocumentoRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
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
    

    public Documento(DocumentoRequest documentoRequest, Beneficiario beneficiario) {
        this.tipoDocumento = documentoRequest.getTipoDocumento();
        this.descricao = documentoRequest.getDescricao();
        this.dataAtualizacao = LocalDateTime.now();
        this.dataInclusao = LocalDateTime.now();
        this.beneficiario= beneficiario;

    }
}

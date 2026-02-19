package com.VagasBoot.Boot.Vagas.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vaga_tech")
public class Vaga {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_vaga")
    private String tituloVaga;

    @Enumerated(EnumType.STRING)
    @Column(name = "senioridade",nullable = false, length = 20)
    private TipoVaga tipoVaga;

    @Column(name = "descricao",nullable = false)
    private String descricao;

    @Column(name = "stacks",nullable = false,length = 500)
    private String tecnologias;

    @Column(name = "empresa",nullable = false,length = 150)
    private String empresa;

    @Column(name = "localizacao",nullable = false,length = 150)
    private String localizacao;

    @Column(name = "data_publicacao",nullable = false)
    private LocalDateTime dataPublicacao;

    @Column(name = "data_captura",nullable = false)
    private LocalDateTime dataCaptura;

    @Column(name = "link_vaga", unique = true, nullable = false)
    private String link;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private TipoStatus status;




}

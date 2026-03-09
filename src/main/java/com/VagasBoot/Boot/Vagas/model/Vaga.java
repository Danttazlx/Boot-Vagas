package com.VagasBoot.Boot.Vagas.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vaga")
public class Vaga {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo",nullable = false)
    private String tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private TipoStatus status;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "link", nullable = false, unique = true)
    private String link;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "expediente")
    private String expediente;

    @Column(name = "salario", length = 70)
    private String salario;

    @Column(name = "area", length = 255)
    private String area;

}

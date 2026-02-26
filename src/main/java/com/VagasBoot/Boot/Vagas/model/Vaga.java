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
    @Table(name = "vaga")
    public class Vaga {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "titulo_vaga",nullable = false)
        private String tituloVaga;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false, length = 20)
        private TipoStatus status;

        @Column(name = "descricao", nullable = false)
        private String descricao;

        @Column(name = "link", nullable = false, unique = true)
        private String link;

        @Column(name = "data_criacao", nullable = false)
        private LocalDateTime dataCriacao;

        @Column(name = "localizacao_vaga", nullable = false)
        private String localizacao;

        @Column(name = "empresa", nullable = false)
        private String empresa;

    }

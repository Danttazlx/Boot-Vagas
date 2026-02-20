package com.VagasBoot.Boot.Vagas.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VagaDTO {

    private String titulo;

    private String senioridade;

    private String descricao;

    private String tecnologias;

    private String empresa;

    private String localizacao;

    private LocalDateTime dataPublicacao;

    private String link;
}

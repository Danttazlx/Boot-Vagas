package com.VagasBoot.Boot.Vagas.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VagaDTO {

    private String descricao;

    private String tipo;

    private String area;

    private String localizacao;

    private String horario;

    private String salario;

    private String href;

    private String linkcompleto;

    private LocalDateTime dataCriacao;

}
package com.VagasBoot.Boot.Vagas.service;

import com.VagasBoot.Boot.Vagas.dto.VagaDTO;
import com.VagasBoot.Boot.Vagas.model.Vaga;
import com.VagasBoot.Boot.Vagas.repository.RepositoryVaga;

import java.util.List;

public class ServiceVaga {

    private final RepositoryVaga repositoryVaga;

    public ServiceVaga(RepositoryVaga repositoryVaga) {
        this.repositoryVaga = repositoryVaga;
    }

    public void processarVaga(VagaDTO dtoVaga) {


        if (dtoVaga.getLink() == null || dtoVaga.getLink().isBlank()) {
            throw new IllegalArgumentException("Link vazio");
        }

        if (repositoryVaga.existsByLink(dtoVaga.getLink())) {
            System.out.println("link existente no banco!");
            return;
        }

        Vaga vaga = converterDto(dtoVaga);
        repositoryVaga.save(vaga);

    }
    public Vaga converterDto(VagaDTO dto) {


        Vaga vaga = new Vaga();

        vaga.setTituloVaga(dto.getTitulo());
        vaga.setDescricao(dto.getDescricao());
        vaga.setEmpresa(dto.getEmpresa());
        vaga.setLocalizacao(dto.getLocalizacao());
        vaga.setDataCriacao(dto.getDataPublicacao());
        vaga.setLink(dto.getLink());

        String tituloVaga = vaga.getTituloVaga().toLowerCase().trim();

         List<String> filtro = List.of(
                "estagio",
                "estagio java",
                "estagio ti",
                "suporte n1",
                "estagio desenvolvimento",
                "suporte tecnico n1",
                "suporte tecnico n2",
                "estagio desenvolvimento de software java",
                "suporte",
                "n1",
                "help desk",
                "suporte tecnico",
                "estagio desenvolvimento java");




        for (String lista : filtro) {
            if (tituloVaga.contains(lista)) {
                vaga.setTituloVaga(tituloVaga);
                break;
            }
        }
        return vaga;

    }
}

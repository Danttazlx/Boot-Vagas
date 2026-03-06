package com.VagasBoot.Boot.Vagas.service;

import com.VagasBoot.Boot.Vagas.dto.VagaDTO;
import com.VagasBoot.Boot.Vagas.model.Vaga;
import com.VagasBoot.Boot.Vagas.repository.RepositoryVaga;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVaga {

    private final RepositoryVaga repositoryVaga;

    public ServiceVaga(RepositoryVaga repositoryVaga) {
        this.repositoryVaga = repositoryVaga;
    }

    public void processarVaga(VagaDTO dtoVaga) {


        if (dtoVaga.getLinkcompleto() == null || dtoVaga.getLinkcompleto().isBlank()) {
            throw new IllegalArgumentException("Link vazio");
        }

        if (repositoryVaga.existsByLink(dtoVaga.getLinkcompleto())) {
            System.out.println("link existente no banco!");
            return;
        }

        Vaga vaga = converterDto(dtoVaga);
        repositoryVaga.save(vaga);

    }

    public Vaga converterDto(VagaDTO dto) {


        Vaga vaga = new Vaga();

        vaga.setTipo(dto.getTipo());
        vaga.setDescricao(dto.getDescricao());
        vaga.setLocalizacao(dto.getLocalizacao());
        vaga.setSalario(dto.getSalario());
        vaga.setDescricao(dto.getDescricao());

        vaga.setLink(dto.getLinkcompleto());

        String tituloVaga = vaga.getTipo().toLowerCase().trim();

        List<String> filtro = List.of(

            "estagio ti ",
                "estagio java",
                "estagio ti",
                "suporte n1",
                "estagio desenvolvimento",
                "suporte tecnico n1",
                "suporte tecnico n2",
                "estagio desenvolvimento de software java",
                "suporte",
                "n1",
                "helpdesk",
                "suporte tecnico",
                "estagio desenvolvimento java");


        for (String lista : filtro) {
            if (tituloVaga.contains(lista)) {
                vaga.setTipo(tituloVaga);
                break;
            }
        }
        return vaga;

    }

}

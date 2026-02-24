package com.VagasBoot.Boot.Vagas.service;

import com.VagasBoot.Boot.Vagas.dto.VagaDTO;
import com.VagasBoot.Boot.Vagas.repository.RepositoryVaga;

public class ServiceVaga {

    private final RepositoryVaga repositoryVaga;

    public ServiceVaga(RepositoryVaga repositoryVaga) {
        this.repositoryVaga = repositoryVaga;
    }

        public void processarVaga (VagaDTO dtoVaga){

        if (dtoVaga.getLink() == null || dtoVaga.getLink().isBlank()){
              throw new IllegalArgumentException("Link vazio");

            }




    }

}

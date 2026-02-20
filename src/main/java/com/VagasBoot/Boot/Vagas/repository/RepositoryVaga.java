package com.VagasBoot.Boot.Vagas.repository;

import com.VagasBoot.Boot.Vagas.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryVaga extends JpaRepository< Vaga,Long> {


   Boolean existsByLink(String link);




}

package com.VagasBoot.Boot.Vagas.service;

import com.VagasBoot.Boot.Vagas.dto.VagaDTO;
import com.VagasBoot.Boot.Vagas.exception.NotFoundRuntimeException;
import com.VagasBoot.Boot.Vagas.model.TipoStatus;
import com.VagasBoot.Boot.Vagas.model.Vaga;
import com.VagasBoot.Boot.Vagas.repository.RepositoryVaga;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceVaga {

    private final RepositoryVaga repositoryVaga;
    private static final String SEARCH = ".*\\b%s\\b.*";

    public ServiceVaga(RepositoryVaga repositoryVaga) {
        this.repositoryVaga = repositoryVaga;
    }

    public void processarVaga(VagaDTO dtoVaga) {


        if (dtoVaga.getLinkcompleto() == null || dtoVaga.getLinkcompleto().isBlank()) {
            throw new NotFoundRuntimeException("link null");
        }

        if (repositoryVaga.existsByLink(dtoVaga.getLinkcompleto())) {
            log.info("Vaga ignorada - link existente no banco, link: {} ", dtoVaga.getLinkcompleto());
            return;
        }

        Vaga vaga = converterDto(dtoVaga);

        if (vaga == null) {
            log.warn("Vaga descartada — não passou nos filtros | link: {}", dtoVaga.getLinkcompleto());
            return;
        }
        repositoryVaga.save(vaga);

    }

    public Vaga converterDto(VagaDTO dto) {

        String descricao = dto.getDescricao() != null ? dto.getDescricao().toLowerCase().trim() : "";

        List<String> filtro = List.of(
                "estagio", "java", "suporte",
                "spring boot", "helpdesk", "help desk",
                "desenvolvimento", "java", "informatica",
                "programador", "sistemas", "ti");

        boolean passou = false;
        for (String palavra : filtro) {
            if (descricao.matches(String.format(SEARCH, palavra))) {
                passou = true;
                break;
            }
        }


        if (!passou){
            log.warn("Vaga descartada - Descricao nao passou pelo filto de palavras-chaves link: {} ", dto.getLinkcompleto());
            return null;}  // descarta


        List<String> areasValidas = List.of("informatica", "ti", "tecnologia", "sistemas");


        if (dto.getTipo() == null || dto.getArea() == null ||
                !dto.getTipo().equalsIgnoreCase("Estagio") ||
                areasValidas.stream().noneMatch(a -> a.equalsIgnoreCase(dto.getArea()))) {
            log.warn("Vaga Descartada - é Preciso ser Estagio e as Areas nao atende ao criterio necessario.| linkTipo: {} | linkArea: {} "
                    ,dto.getTipo(),dto.getArea());

            return null;
        }

        Vaga vaga = new Vaga();
        vaga.setTipo(dto.getTipo());
        vaga.setDescricao(dto.getDescricao());
        vaga.setLocalizacao(dto.getLocalizacao());
        vaga.setSalario(dto.getSalario());
        vaga.setArea(dto.getArea());
        vaga.setLink(dto.getLinkcompleto());
        vaga.setStatus(TipoStatus.NEW);
        vaga.setExpediente(dto.getExpediente());

        return vaga;
    }

}

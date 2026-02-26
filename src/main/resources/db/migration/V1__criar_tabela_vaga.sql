

CREATE TABLE vaga (
    id          BIGSERIAL PRIMARY KEY,
    titulo_vaga      VARCHAR(255) NOT NULL,
    empresa     VARCHAR(255) NOT NULL,
    localizacao_vaga VARCHAR(255),
    descricao TEXT NOT NULL,
    link        VARCHAR(500) NOT NULL UNIQUE,
    status      VARCHAR(20)  NOT NULL DEFAULT 'NEW',
    data_criacao TIMESTAMP   NOT NULL
);
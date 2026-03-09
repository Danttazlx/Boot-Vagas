



CREATE TABLE vaga (
    id             BIGSERIAL PRIMARY KEY,
    descricao      VARCHAR(500) NOT NULL,
    tipo           VARCHAR(255) NOT NULL,
    area           VARCHAR(255),
    localizacao    VARCHAR(255),
    salario        VARCHAR(70),
    link           VARCHAR(500) NOT NULL UNIQUE,
    status         VARCHAR(20)  DEFAULT 'NEW',
    expediente     VARCHAR(40)
);
CREATE TABLE topicos (
    id BIGSERIAL NOT NULL,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensagem VARCHAR(100) NOT NULL UNIQUE,
    dataCriacao TIMESTAMP NOT NULL,
    curso VARCHAR(100) NOT NULL,
    ativo BOOLEAN,
    autor_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES autores(id)
    );




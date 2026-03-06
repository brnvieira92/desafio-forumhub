CREATE TABLE usuario (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         senha VARCHAR(255) NOT NULL
);

CREATE TABLE usuario_perfil (
                                usuario_id BIGINT NOT NULL,
                                perfil_id BIGINT NOT NULL,

                                PRIMARY KEY (usuario_id, perfil_id),

                                CONSTRAINT fk_usuario
                                    FOREIGN KEY (usuario_id)
                                        REFERENCES usuario(id)
                                        ON DELETE CASCADE,

                                CONSTRAINT fk_perfil
                                    FOREIGN KEY (perfil_id)
                                        REFERENCES perfil(id)
                                        ON DELETE CASCADE
);
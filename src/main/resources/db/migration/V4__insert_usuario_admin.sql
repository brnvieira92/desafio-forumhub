INSERT INTO usuario (nome, email, senha)
VALUES (
           'Administrador',
           'admin@forumhub.com',
           '$2a$10$dOuZKh96mIIe1cNHnhqhXOvMxUzzrxOdkeCqOifagaLpFXzHdb32i'
       );

INSERT INTO usuario_perfil (usuario_id, perfil_id)
VALUES (1, 3);
package br.com.alura.forumhub.security;

import br.com.alura.forumhub.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private String secret = "12345678";

    public String gerarToken(Usuario usuario) {

        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("forumhub")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);

        } catch (Exception exception) {
            throw new RuntimeException("Erro ao gerar token JWT");
        }
    }

    public String validarToken(String token){

        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("forumhub")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (Exception exception) {
            return "";
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
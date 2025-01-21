package br.com.alura.Forum.Hub.infra.security;

import br.com.alura.Forum.Hub.domain.admin.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
@Service
public class TokenService {
    @Value("${API_SENHA_VOLL.MED}")
    private String secret;

    public String gerarToken(Admin usuario) {
        try {
            var algoritmo  = Algorithm.HMAC256(secret);
            return  JWT.create()
                    .withIssuer("Api Voll.med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw  new RuntimeException("Erro ao gerar token jtw", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo  = Algorithm.HMAC256(secret);

            return  JWT.require(algoritmo)
                    .withIssuer("Api Voll.med")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT invalido ou expirado");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

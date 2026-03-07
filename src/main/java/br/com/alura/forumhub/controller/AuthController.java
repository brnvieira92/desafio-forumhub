package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.dto.LoginDTO;
import br.com.alura.forumhub.dto.TokenDTO;
import br.com.alura.forumhub.entity.Usuario;
import br.com.alura.forumhub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public TokenDTO login(@RequestBody LoginDTO dados){

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        dados.email(),
                        dados.senha()
                );

        var authentication = manager.authenticate(authenticationToken);

        var usuario = (Usuario) authentication.getPrincipal();

        var tokenJWT = tokenService.gerarToken(usuario);

        return new TokenDTO(tokenJWT);
    }
}
package br.com.alura.forumhub;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaGenerator {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senha = "123456";

        String senhaCriptografada = encoder.encode(senha);

        System.out.println(senhaCriptografada);
    }
}
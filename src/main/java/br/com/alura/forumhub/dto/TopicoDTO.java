package br.com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String curso,
        @NotBlank String autorEmail
) {}

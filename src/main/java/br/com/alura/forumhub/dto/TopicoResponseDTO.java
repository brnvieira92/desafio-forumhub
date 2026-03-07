package br.com.alura.forumhub.dto;

import java.time.LocalDateTime;

public record TopicoResponseDTO(
        Long id,
        String titulo,
        String mensagem,
        String curso,
        String status,
        LocalDateTime dataCriacao,
        String autorEmail
) {}

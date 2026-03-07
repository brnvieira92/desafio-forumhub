package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.dto.TopicoDTO;
import br.com.alura.forumhub.dto.TopicoResponseDTO;
import br.com.alura.forumhub.entity.Topico;
import br.com.alura.forumhub.entity.Usuario;
import br.com.alura.forumhub.entity.StatusTopico;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<TopicoResponseDTO> cadastrar(@RequestBody @Valid TopicoDTO dto) {
        Usuario autor = usuarioRepository.findByEmail(dto.autorEmail());
        if (autor == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean existe = topicoRepository.existsByTituloAndMensagem(dto.titulo(), dto.mensagem());
        if (existe) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setCurso(dto.curso());
        topico.setAutor(autor);
        topico.setDataCriacao(LocalDateTime.now());
        topico.setStatus(StatusTopico.ABERTO);

        topicoRepository.save(topico);

        TopicoResponseDTO response = new TopicoResponseDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getCurso(),
                topico.getStatus().name(),
                topico.getDataCriacao(),
                topico.getAutor().getEmail()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponseDTO>> listar() {
        var lista = topicoRepository.findAll()
                .stream()
                .map(topico -> new TopicoResponseDTO(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensagem(),
                        topico.getCurso(),
                        topico.getStatus().name(),
                        topico.getDataCriacao(),
                        topico.getAutor().getEmail()
                ))
                .toList();

        return ResponseEntity.ok(lista);
    }
}

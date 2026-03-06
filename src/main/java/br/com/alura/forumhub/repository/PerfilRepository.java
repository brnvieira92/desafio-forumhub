package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
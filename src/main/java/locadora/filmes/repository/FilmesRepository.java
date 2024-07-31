package locadora.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import locadora.filmes.entity.Filmes;

import java.util.List;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {
    List<Filmes> findAll();
}

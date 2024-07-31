package locadora.filmes.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import locadora.filmes.entity.Filmes;
import locadora.filmes.repository.FilmesRepository;

import java.util.List;


@Service
public class FilmesService {
    @Autowired
    private FilmesRepository filmesRepository;

    public List<Filmes> getAllfilmes() {
        return filmesRepository.findAll();
    }

    public Filmes alugarFilme(Long filmeId, int diasAlugados) {
        Filmes filme = filmesRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        if (diasAlugados <= 0) {
            throw new IllegalArgumentException("O número de dias alugados deve ser maior que zero.");
        }

        filme.setDiasAlugados(diasAlugados);
        filme.setDisponivel(false);

        return filmesRepository.save(filme);
    }
    
    public Filmes devolverFilme(Long filmeId) {
        Filmes filme = filmesRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        if (filme.isDisponivel()) {
            throw new IllegalStateException("O filme já está disponível.");
        }

        filme.setDiasAlugados(0);
        filme.setDisponivel(true);

        return filmesRepository.save(filme);
    }
    }


package locadora.filmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import locadora.filmes.entity.Filmes;
import locadora.filmes.repository.FilmesRepository;
import locadora.filmes.services.FilmesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController {
	@Autowired
	private FilmesService filmesService;
    private FilmesRepository filmesRepository;

	
	@GetMapping("/listfilmes")
	public List<Filmes> getAllfilmes() {
		return filmesService.getAllfilmes();
	}

	@PostMapping("/alugar/{filmeId}")
    public ResponseEntity<String> alugarFilme(
            @PathVariable Long filmeId,
            @RequestBody AlugarFilmeRequest request) {

        int diasAlugados = request.getDiasAlugados();

        if (diasAlugados <= 0) {
            return new ResponseEntity<>("O número de dias alugados deve ser maior que zero.", HttpStatus.BAD_REQUEST);
        }

        try {
            Filmes filmeAlugado = filmesService.alugarFilme(filmeId, diasAlugados);
            return new ResponseEntity<>("Filme alugado com sucesso. ID do filme: " + filmeAlugado.getId(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno do servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	    
	@PostMapping("/devolver/{filmeId}")
	public ResponseEntity<String> devolverFilme(@PathVariable Long filmeId) {
	    try {
	        Filmes filmeDevolvido = filmesService.devolverFilme(filmeId);
	        return new ResponseEntity<>("Filme devolvido com sucesso. ID do filme: " + filmeDevolvido.getId(), HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Erro interno do servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	public static class AlugarFilmeRequest {
	    private int diasAlugados;
	
	    public int getDiasAlugados() {
	        return diasAlugados;
	    }

	    public void setDiasAlugados(int diasAlugados) {
	        this.diasAlugados = diasAlugados;
	    }
	}
	
	public static class DevolverFilmeRequest {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}



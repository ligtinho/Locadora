package locadora.filmes.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Filmes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;    

    @Column(name = "disponivel")
    private boolean disponivel = true;
    
    @Column(name = "dias_alugados")
    private int diasAlugados;
    
    @Column(name = "capa_url")
    private String capaUrl;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getDiasAlugados() {
        return diasAlugados;
    }

    public void setDiasAlugados(int diasAlugados) {
        this.diasAlugados = diasAlugados;
    }

    public String getCapaUrl() {
        return capaUrl;
    }

    public void setCapaUrl(String capaUrl) {
        this.capaUrl = capaUrl;
    }
    
}
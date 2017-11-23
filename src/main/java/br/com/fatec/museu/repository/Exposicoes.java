package br.com.fatec.museu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatec.museu.model.Exposicao;

public interface Exposicoes extends JpaRepository<Exposicao, Long>{

	@Query("SELECT e FROM Exposicao e WHERE LOWER(e.nome) = LOWER(:nome) ")
	public List<Exposicao> findByName(@Param("nome") String nome);
	
}

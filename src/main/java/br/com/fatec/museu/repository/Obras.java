package br.com.fatec.museu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatec.museu.model.Obra;

public interface Obras extends JpaRepository<Obra, Long>{

	@Query("SELECT o FROM Obra o WHERE (LOWER(o.nomeAutor) = LOWER(:obra) OR LOWER(o.nome) = LOWER(:obra)) ")
	public List<Obra> findByAutorOrName(@Param("obra") String obra);
	
}

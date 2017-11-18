package br.com.fatec.museu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.museu.model.Obra;

public interface Obras extends JpaRepository<Obra, Long>{

}

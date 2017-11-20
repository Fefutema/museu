package br.com.fatec.museu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Obra implements Serializable {

	private static final long serialVersionUID = 10L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Column(name="NOME_AUTOR")
	private String nomeAutor;
	
	@Column(name="NOME_OBRA")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="NOME_EXPOSICAO")
	private String nomeExposicao;

	public Obra() {
	}

	public Obra(Long id, String nomeAutor, String nome, String descricao, String nomeExposicao) {
		this.id = id;
		this.nomeAutor = nomeAutor;
		this.nome = nome;
		this.descricao = descricao;
		this.nomeExposicao = nomeExposicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeExposicao() {
		return nomeExposicao;
	}

	public void setNomeExposicao(String nomeExposicao) {
		this.nomeExposicao = nomeExposicao;
	}

}

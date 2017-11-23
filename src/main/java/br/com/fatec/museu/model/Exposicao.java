package br.com.fatec.museu.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exposicao implements Serializable {

	private static final long serialVersionUID = 30L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(generator = "increment")
	// @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "TIPO_EXPOSICAO")
	private String tipo;

	@Column(name = "NOME_EXPOSICAO")
	private String nome;

	@Column(name = "SALA_RESERVADA")
	private String salaReservada;

	@Column(name = "DESC_EXPOSICAO")
	private String descricao;

	@Column(name = "HORARIO_EXPOSICAO")
	private String horarioFuncionamento;

	@Column(name = "MAX_VISITANTES")
	private Integer maxVisitantes;

	@OneToMany(mappedBy = "exposicao", cascade = CascadeType.ALL)
	private Set<Obra> obras;

	public Exposicao() {
	}

	
	public Exposicao(Long id, String tipo, String nome, String salaReservada, String descricao,
			String horarioFuncionamento, Integer maxVisitantes) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.salaReservada = salaReservada;
		this.descricao = descricao;
		this.horarioFuncionamento = horarioFuncionamento;
		this.maxVisitantes = maxVisitantes;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSalaReservada() {
		return salaReservada;
	}

	public void setSalaReservada(String salaReservada) {
		this.salaReservada = salaReservada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public Integer getMaxVisitantes() {
		return maxVisitantes;
	}

	public void setMaxVisitantes(Integer maxVisitantes) {
		this.maxVisitantes = maxVisitantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Obra> getObras() {
		return obras;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
	}

}

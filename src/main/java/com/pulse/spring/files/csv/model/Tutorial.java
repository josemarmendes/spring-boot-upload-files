package com.pulse.spring.files.csv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	 * @Column(name = "frequencia") private Integer frequencia;
	 */
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "publicacao")
	private String publicacao;

	public Tutorial() {

	}

	public Tutorial(long id, String titulo, String descricao, String publicacao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.publicacao = publicacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	/*
	 * public Integer getFrequencia() { return frequencia; }
	 * 
	 * public void setFrequencia(Integer frequencia) { this.frequencia = frequencia;
	 * }
	 */

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", titulo=" + titulo + ", desc=" + descricao + ", publicado=" + publicacao + "]";
	}

}

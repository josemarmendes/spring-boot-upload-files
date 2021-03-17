package com.pulse.spring.files.csv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "previsao_inventario")
public class PrevisaoInventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "modalidade")
	private String modalidade;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "mes")
	private Integer mes;

	@Column(name = "idFilial")
	private Integer idFilial;

	@Column(name = "idSetor")
	private Integer idSetor;

	@Column(name = "frequencia")
	private Integer frequencia;

	public PrevisaoInventario() {

		}

	public PrevisaoInventario(long id, String modalidade, Integer ano, Integer mes, Integer idFilial, Integer idSetor,
				Integer frequencia) {
			this.id = id;
			this.modalidade = modalidade;
			this.ano = ano;
			this.mes = mes;
			this.idFilial = idFilial;
			this.idSetor = idSetor;
			this.frequencia = frequencia;
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(Integer idFilial) {
		this.idFilial = idFilial;
	}

	public Integer getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

}

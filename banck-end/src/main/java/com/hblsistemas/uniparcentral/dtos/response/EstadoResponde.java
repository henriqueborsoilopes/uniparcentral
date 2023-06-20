package com.hblsistemas.uniparcentral.dtos.response;

import java.io.Serializable;

public class EstadoResponde implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sigla;
	private String paisNome;
	
	public EstadoResponde() { }

	public EstadoResponde(Long id, String nome, String sigla, String paisNome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.paisNome = paisNome;
	}

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getPaisNome() {
		return paisNome;
	}

	public void setPaisNome(String paisNome) {
		this.paisNome = paisNome;
	}
}

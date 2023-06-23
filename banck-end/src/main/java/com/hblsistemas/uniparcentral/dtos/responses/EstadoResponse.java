package com.hblsistemas.uniparcentral.dtos.responses;

import java.io.Serializable;

public class EstadoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sigla;
	private PaisResponse paisResponse;
	
	public EstadoResponse() { }

	public EstadoResponse(Long id, String nome, String sigla, PaisResponse paisResponse) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.paisResponse = paisResponse;
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

	public PaisResponse getPaisResponse() {
		return paisResponse;
	}

	public void setPaisResponse(PaisResponse paisResponse) {
		this.paisResponse = paisResponse;
	}
}

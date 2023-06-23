package com.hblsistemas.uniparcentral.dtos.responses;

import java.io.Serializable;

public class CidadeResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String estadoNome;
	
	public CidadeResponse() { }

	public CidadeResponse(Long id, String nome, String estadoNome) {
		super();
		this.id = id;
		this.nome = nome;
		this.estadoNome = estadoNome;
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

	public String getEstadoNome() {
		return estadoNome;
	}

	public void setEstadoNome(String estadoNome) {
		this.estadoNome = estadoNome;
	}
}

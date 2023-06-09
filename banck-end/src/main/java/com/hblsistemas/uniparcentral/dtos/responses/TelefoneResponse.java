package com.hblsistemas.uniparcentral.dtos.responses;

import java.io.Serializable;

public class TelefoneResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String numero;
	private Integer tipoOperadora;
	
	public TelefoneResponse() { }

	public TelefoneResponse(Long id, String numero, Integer tipoOperadora) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipoOperadora = tipoOperadora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getTipoOperadora() {
		return tipoOperadora;
	}

	public void setTipoOperadora(Integer tipoOperadora) {
		this.tipoOperadora = tipoOperadora;
	}
}

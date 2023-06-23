package com.hblsistemas.uniparcentral.dtos.responses;

import java.io.Serializable;

public class EnderecoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;
	
	public EnderecoResponse() { }

	public EnderecoResponse(Long id, String logradouro, String numero, String bairro, String cep, String complemento) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}

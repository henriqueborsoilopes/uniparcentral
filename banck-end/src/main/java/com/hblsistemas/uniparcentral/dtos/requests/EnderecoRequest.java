package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

public class EnderecoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String registroAluno;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;
	private Long cidade_id;
	private Long morador_id;
	
	public EnderecoRequest() { }

	public EnderecoRequest(Long id, String registroAluno, String logradouro, String numero,
			String bairro, String cep, String complemento, Long cidade_id, Long morador_id) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.cidade_id = cidade_id;
		this.morador_id = morador_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
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

	public Long getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Long cidade_id) {
		this.cidade_id = cidade_id;
	}

	public Long getMorador_id() {
		return morador_id;
	}

	public void setMorador_id(Long morador_id) {
		this.morador_id = morador_id;
	}
}

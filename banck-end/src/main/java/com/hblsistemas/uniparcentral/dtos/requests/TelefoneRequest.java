package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

public class TelefoneRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String registroAluno;
	private String numero;
	private Integer tipoOperadora;
	private Long titularAgencia_id;
	private Long titularPessoa_id;
	
	public TelefoneRequest() { }

	public TelefoneRequest(Long id, String registroAluno, String numero, Integer tipoOperadora, Long titularAgencia_id,
			Long titularPessoa_id) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.numero = numero;
		this.tipoOperadora = tipoOperadora;
		this.titularAgencia_id = titularAgencia_id;
		this.titularPessoa_id = titularPessoa_id;
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

	public Long getTitularAgencia_id() {
		return titularAgencia_id;
	}

	public void setTitularAgencia_id(Long titularAgencia_id) {
		this.titularAgencia_id = titularAgencia_id;
	}

	public Long getTitularPessoa_id() {
		return titularPessoa_id;
	}

	public void setTitularPessoa_id(Long titularPessoa_id) {
		this.titularPessoa_id = titularPessoa_id;
	}
}

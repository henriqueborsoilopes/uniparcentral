package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

import com.hblsistemas.uniparcentral.entidades.enums.TipoOperadora;

public class TelefoneRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String registroAluno;
	private String numero;
	private Integer tipoOperadora;
	private Long titularAgenciaId;
	private Long titularPessoaId;
	
	public TelefoneRequest() { }

	public TelefoneRequest(Long id, String registroAluno, String numero, Integer tipoOperadora, Long titularAgenciaId,
			Long titularPessoaId) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.numero = numero;
		this.tipoOperadora = tipoOperadora;
		this.titularAgenciaId = titularAgenciaId;
		this.titularPessoaId = titularPessoaId;
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

	public TipoOperadora getTipoOperadora() {
		return TipoOperadora.paraEnum(tipoOperadora);
	}

	public void setTipoOperadora(Integer tipoOperadora) {
		this.tipoOperadora = tipoOperadora;
	}

	public Long getTitularAgenciaId() {
		return titularAgenciaId;
	}

	public void setTitularAgenciaId(Long titularAgenciaId) {
		this.titularAgenciaId = titularAgenciaId;
	}

	public Long getTitularPessoaId() {
		return titularPessoaId;
	}

	public void setTitularPessoaId(Long titularPessoaId) {
		this.titularPessoaId = titularPessoaId;
	}
}

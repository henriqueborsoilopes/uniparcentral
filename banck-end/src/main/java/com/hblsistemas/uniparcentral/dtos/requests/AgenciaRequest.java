package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

public class AgenciaRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String registroAluno;
	private String codigo;
	private String digito;
	private String razaoSocial;
	private String cnpj;
	private Long banco_id;
	
	public AgenciaRequest() { }

	public AgenciaRequest(Long id, String registroAluno, String codigo, String digito, String razaoSocial, String cnpj, Long banco_id) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.codigo = codigo;
		this.digito = digito;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.banco_id = banco_id;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getBanco_id() {
		return banco_id;
	}

	public void setBanco_id(Long banco_id) {
		this.banco_id = banco_id;
	}
}

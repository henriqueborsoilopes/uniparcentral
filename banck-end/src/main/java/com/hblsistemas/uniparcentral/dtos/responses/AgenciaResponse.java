package com.hblsistemas.uniparcentral.dtos.responses;

import java.io.Serializable;

public class AgenciaResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String codigo;
	private String digito;
	private String razaoSocial;
	private String cnpj;
	
	public AgenciaResponse() { }

	public AgenciaResponse(Long id, String codigo, String digito, String razaoSocial, String cnpj) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.digito = digito;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
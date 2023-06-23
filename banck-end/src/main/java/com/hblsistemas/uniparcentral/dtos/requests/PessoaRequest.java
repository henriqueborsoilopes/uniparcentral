package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = PessoaFisicaRequest.class, name = "pessoaJuridica"),
    @JsonSubTypes.Type(value = PessoaJuridicaRequest.class, name = "pessoaFisica")
})
public abstract class PessoaRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String registroAluno;
	
	public PessoaRequest() { }

	public PessoaRequest(Long id, String email, String registroAluno) {
		super();
		this.id = id;
		this.email = email;
		this.registroAluno = registroAluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}
}

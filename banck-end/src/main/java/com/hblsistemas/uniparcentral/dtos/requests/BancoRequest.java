package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

public class BancoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String registroAluno;
	private String nome;
	
	public BancoRequest() { }

	public BancoRequest(Long id, String registroAluno, String nome) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

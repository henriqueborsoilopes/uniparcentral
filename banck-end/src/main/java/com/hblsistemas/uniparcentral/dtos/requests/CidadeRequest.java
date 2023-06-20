package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

public class CidadeRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String registroAluno;
	private String nome;
	private Long estado_id;
	
	public CidadeRequest() { }

	public CidadeRequest(Long id, String registroAluno, String nome, Long estado_id) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.nome = nome;
		this.estado_id = estado_id;
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

	public Long getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Long estado_id) {
		this.estado_id = estado_id;
	}
}

package com.hblsistemas.uniparcentral.dtos.requests;

import java.time.LocalDateTime;

public class PessoaFisicaRequest extends PessoaRequest {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String rg;
	private LocalDateTime dataNascimento;
	
	public PessoaFisicaRequest() { }

	public PessoaFisicaRequest(String nome, String cpf, String rg, LocalDateTime dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}

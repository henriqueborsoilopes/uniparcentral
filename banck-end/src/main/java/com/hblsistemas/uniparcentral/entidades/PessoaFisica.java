package com.hblsistemas.uniparcentral.entidades;

import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;

import jakarta.persistence.Entity;

@Entity
@JsonTypeName("pessoaFisica")
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	
	public PessoaFisica() { }

	public PessoaFisica(Long id, String email, String registroAluno, Instant dataCadastro, String nome, String cpf,
			String rg, LocalDate dataNascimento) {
		super(id, email, registroAluno, dataCadastro);
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}

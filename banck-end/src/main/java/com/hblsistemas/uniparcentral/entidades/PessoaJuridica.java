package com.hblsistemas.uniparcentral.entidades;

import java.time.Instant;

import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;

import jakarta.persistence.Entity;

@Entity
//@JsonTypeName("pessoaJuridica")
public class PessoaJuridica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String razaoSocial;
	private String cnpj;
	private String cnaePrincipal;
	private String nomeFantasia;
	
	public PessoaJuridica() { }

	public PessoaJuridica(Long id, String email, String registroAluno, Instant dataCadastro, String razaoSocial,
			String cnpj, String cnaePrincipal, String nomeFantasia) {
		super(id, email, registroAluno, dataCadastro);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cnaePrincipal = cnaePrincipal;
		this.nomeFantasia = nomeFantasia;
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

	public String getCnaePrincipal() {
		return cnaePrincipal;
	}

	public void setCnaePrincipal(String cnaePrincipal) {
		this.cnaePrincipal = cnaePrincipal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}

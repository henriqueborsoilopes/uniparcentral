package com.hblsistemas.uniparcentral.dtos.requests;

public class PessoaJuridicaRequest extends PessoaRequest {
	private static final long serialVersionUID = 1L;
	
	private String razaoSocial;
	private String cnpj;
	private String cnaePrincipal;
	private String nomeFantasia;
	
	public PessoaJuridicaRequest() { }

	public PessoaJuridicaRequest(Long id, String email, String registroAluno, String razaoSocial, String cnpj,
			String cnaePrincipal, String nomeFantasia) {
		super(id, email, registroAluno);
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

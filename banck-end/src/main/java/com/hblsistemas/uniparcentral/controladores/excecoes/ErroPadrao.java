package com.hblsistemas.uniparcentral.controladores.excecoes;

import java.time.Instant;

public class ErroPadrao {
	
    private Instant momento;
    private Integer status;
    private String erro;
    private String caminho;
    private String mensagem;
    
    public ErroPadrao() { }

	public ErroPadrao(Instant momento, Integer status, String erro, String caminho, String mensagem) {
		super();
		this.momento = momento;
		this.status = status;
		this.erro = erro;
		this.caminho = caminho;
		this.mensagem = mensagem;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

package com.hblsistemas.uniparcentral.servicos.excecoes;

public class ValidacaoExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ValidacaoExcecao(String msg) {
		super(msg);
	}
}

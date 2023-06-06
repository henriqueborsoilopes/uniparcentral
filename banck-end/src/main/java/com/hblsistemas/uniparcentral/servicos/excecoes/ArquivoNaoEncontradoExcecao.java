package com.hblsistemas.uniparcentral.servicos.excecoes;

public class ArquivoNaoEncontradoExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ArquivoNaoEncontradoExcecao(String msg) {
		super(msg);
	}
}

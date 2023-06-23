package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.dtos.requests.BancoRequest;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class BancoValidacao {
	
	public static void validarTodosCampos(BancoRequest request) {
		validarObjetoNulo(request);
		validarNome(request.getNome());
		validarRegistroAluno(request.getRegistroAluno());
	}
	
	private static void validarObjetoNulo(BancoRequest request) {
		if (request == null) {
			throw new ValidacaoExcecao("Os dados do Banco são obrigatório o preenchimento.");
		}
	}
	
	private static void validarRegistroAluno(String ra) {
		if (ra == null) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (ra.isBlank()) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (ra.isEmpty()) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (ra.length() < 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		} else if (ra.length() > 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		}
	}
	
	private static void validarNome(String nome) {
		if (nome == null) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (nome.isBlank()) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (nome.isEmpty()) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (nome.length() > 120) {
			throw new ValidacaoExcecao("O campo Nome deve conter 8 caracteres.");
		}	
	}
}

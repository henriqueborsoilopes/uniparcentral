package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.dtos.requests.PaisRequest;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class PaisValidacao {
	
	public static void validarTodosCampos(PaisRequest request) {
		validarObjetoNulo(request);
		validarNome(request.getNome());
		validarRegistroAluno(request.getRegistroAluno());
		validarSigla(request.getSigla());
	}
	
	private static void validarObjetoNulo(PaisRequest request) {
		if (request == null) {
			throw new ValidacaoExcecao("É obrigatório que um País seja válido!");
		}
	}
	
	private static void validarRegistroAluno(String ra) {
		if (ra.isBlank() || ra.isEmpty() || ra == null) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (ra.length() < 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter no mínimo 8 caracteres.");
		} else if (ra.length() > 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter no máximo 8 caracteres.");
		}
	}
	
	private static void validarNome(String nome) {
		if (nome.isBlank() || nome.isEmpty() || nome == null) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (nome.length() > 120) {
			throw new ValidacaoExcecao("O campo Nome deve conter no máximo 120 caracteres.");
		}	
	}
	
	private static void validarSigla(String sigla) {
		if (sigla.isBlank() || sigla.isEmpty() || sigla == null) {
			throw new ValidacaoExcecao("O campo Sigla é obrigatório o preenchimento.");
		} else if (sigla.length() > 3) {
			throw new ValidacaoExcecao("O campo Sigla deve conter no máximo 3 caracteres.");
		}
	}
}

package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.Transacao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class TransacaoValidacao {

	public static void validarTodosCampos(Transacao transacao) {
		validarObjetoNulo(transacao);
		validarRegistroAluno(transacao.getRegistroAluno());
	}

	private static void validarObjetoNulo(Transacao transacao) {
		if (transacao == null) {
			throw new ValidacaoExcecao("Os dados da Conta são obrigatório o preenchimento.");
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
}

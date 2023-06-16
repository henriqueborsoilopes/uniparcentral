package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class AgenciaValidacao {
	
	public static void validarTodosCampos(Agencia agencia) {
		validarObjetoNulo(agencia);
		validarRazaosocial(agencia.getRazaoSocial());
		validarRegistroAluno(agencia.getRegistroAluno());
	}
	
	private static void validarObjetoNulo(Agencia agencia) {
		if (agencia == null) {
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
	
	private static void validarRazaosocial(String razaosocial) {
		if (razaosocial == null) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (razaosocial.isBlank()) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (razaosocial.isEmpty()) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (razaosocial.length() > 120) {
			throw new ValidacaoExcecao("O campo Nome deve conter 8 caracteres.");
		}	
	}
}

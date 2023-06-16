package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class CidadeValidacao {
		
	public static void validarTodosCamposParaInserir(Cidade cidade) {
		validarTodosCamposParaUpdate(cidade);
		validarEstadoId(cidade.getEstado().getId());
	}
	
	public static void validarTodosCamposParaUpdate(Cidade cidade) {
		validarObjetoNulo(cidade);
		validarNome(cidade.getNome());
		validarRegistroAluno(cidade.getRegistroAluno());
	}
	
	private static void validarObjetoNulo(Cidade cidade) {
		if (cidade == null) {
			throw new ValidacaoExcecao("É obrigatório que um Cidade seja válido!");
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
			throw new ValidacaoExcecao("O campo Nome deve conter no máximo 120 caracteres.");
		}
	}
	
	private static void validarEstadoId(Long estadoId) {
		if (estadoId == null) {
			throw new ValidacaoExcecao("É obrigatório que um Estado seja válido!");
		}
	}
}

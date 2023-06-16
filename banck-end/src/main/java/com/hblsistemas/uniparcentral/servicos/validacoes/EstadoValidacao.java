package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.Estado;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class EstadoValidacao {
	
	public static void validarTodosCamposParaInserir(Estado estado) {
		validarTodosCamposParaUpdate(estado);
		validarPaisId(estado.getPais() == null ? null : estado.getPais().getId());
	}
	
	public static void validarTodosCamposParaUpdate(Estado estado) {
		validarObjetoNulo(estado);
		validarNome(estado.getNome());
		validarRegistroAluno(estado.getRegistroAluno());
		validarSigla(estado.getSigla());
	}
	
	private static void validarObjetoNulo(Estado estado) {
		if (estado == null) {
			throw new ValidacaoExcecao("É obrigatório que um Estado seja válido!");
		}
	}
	
	private static void validarRegistroAluno(String ra) {
		if (ra == null || ra.isBlank() || ra.isEmpty()) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (ra.length() < 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter no mínimo 8 caracteres.");
		} else if (ra.length() > 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter no máximo 8 caracteres.");
		}
	}
	
	private static void validarNome(String nome) {
		if (nome == null || nome.isBlank() || nome.isEmpty()) {
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
	
	private static void validarPaisId(Long paisId) {
		if (paisId == null) {
			throw new ValidacaoExcecao("É obrigatório que um País seja válido!");
		}
	}
}

package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.dtos.requests.TelefoneRequest;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class TelefoneValidacao {
	
	public static void validarTodosCampos(TelefoneRequest request) {
		validarObjetoNulo(request);
		validarRegistroAluno(request.getRegistroAluno());
		validarTelNumero(request.getNumero());
		validarTitularAgencia(request.getTitularAgenciaId());
		validarTitularPessoa(request.getTitularPessoaId());
	}
	
	private static void validarObjetoNulo(TelefoneRequest request) {
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
	
	private static void validarTelNumero(String numero) {
		if (numero == null) {
			throw new ValidacaoExcecao("O campo Número do Telefone é obrigatório o preenchimento.");
		} else if (numero.isBlank()) {
			throw new ValidacaoExcecao("O campo Número do Telefone é obrigatório o preenchimento.");
		} else if (numero.isEmpty()) {
			throw new ValidacaoExcecao("O campo Número do Telefone é obrigatório o preenchimento.");
		} else if (numero.length() > 11) {
			throw new ValidacaoExcecao("O campo Número do Telefone deve conter 11 caracteres.");
		}	
	}
	
	private static void validarTitularAgencia(Long agencia) {
		if (agencia == null) {
			throw new ValidacaoExcecao("O compo Agencia é obrigatório o preenchimento");
		}
	}
	
	private static void validarTitularPessoa(Long pessoa) {
		if (pessoa == null) {
			throw new ValidacaoExcecao("O compo Pessoa é obrigatório o preenchimento");
		}
	}
}

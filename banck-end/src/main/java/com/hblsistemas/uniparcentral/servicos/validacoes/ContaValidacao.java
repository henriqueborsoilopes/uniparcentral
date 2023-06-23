package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.dtos.requests.ContaRequest;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class ContaValidacao {
	
	public static void validarTodosCampos(ContaRequest request) {
		validarObjetoNulo(request);
		validarRegistroAluno(request.getRegistroAluno());
		validarAgenciaId(request.getAgencia_id());
		validarNumero(request.getNumero());
		validarDigito(request.getDigito());
		validarTitularId(request.getTitular_id());
	}

	private static void validarObjetoNulo(ContaRequest request) {
		if (request == null) {
			throw new ValidacaoExcecao("Os dados da Conta são obrigatório o preenchimento.");
		}
	}
	
	public static void validarSaldo(Double saldo) {
		if (saldo == null) {
			throw new ValidacaoExcecao("Erro! Campo Saldo está nulo.");
		}
	}
	
	public static void validarTipo(Integer tipo) {
		if (tipo == null) {
			throw new ValidacaoExcecao("Erro! Campo Saldo está nulo.");
		}
	}
	
	private static void validarNumero(String numero) {
		if (numero == null || numero.isBlank() || numero.isEmpty()) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (numero.length() < 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		} else if (numero.length() > 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		}
	}
	
	private static void validarDigito(String digito) {
		if (digito == null || digito.isBlank() || digito.isEmpty()) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (digito.length() < 2) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		} else if (digito.length() > 2) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		}
	}

	private static void validarRegistroAluno(String ra) {
		if (ra == null || ra.isBlank() || ra.isEmpty()) {
			throw new ValidacaoExcecao("O campo Registro do Aluno é obrigatório o preenchimento.");
		} else if (ra.length() < 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		} else if (ra.length() > 8) {
			throw new ValidacaoExcecao("O campo Registro do Aluno deve conter 8 caracteres.");
		}
	}
	
	private static void validarTitularId(Long titularId) {
		if (titularId == null) {
			throw new ValidacaoExcecao("O campo Titular é obrigatório o preenchimento.");
		}
	}
	
	private static void validarAgenciaId(Long agenciaId) {
		if (agenciaId == null) {
			throw new ValidacaoExcecao("O campo Agencia é obrigatório o preenchimento.");
		}
	}
}

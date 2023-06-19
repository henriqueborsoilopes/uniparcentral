package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class ContaValidacao {
	
//	INSERT INTO conta (id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id)
//	VALUES (33, '211498', '21', 582.35, 1, '00240508', 9, 15);

	public static void validarTodosCampos(Conta conta) {
		validarObjetoNulo(conta);
		validarRegistroAluno(conta.getRegistroAluno());
		validarAgenciaId(conta.getAgencia().getId());
		validarNumero(conta.getNumero());
		validarDigito(conta.getDigito());
		validarTitularId(conta.getTitular().getId());
	}

	private static void validarObjetoNulo(Conta conta) {
		if (conta == null) {
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

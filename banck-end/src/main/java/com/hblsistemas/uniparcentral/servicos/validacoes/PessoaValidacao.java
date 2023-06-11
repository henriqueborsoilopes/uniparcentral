package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.PessoaFisica;
import com.hblsistemas.uniparcentral.entidades.PessoaJuridica;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class PessoaValidacao {
	
	public static void validarTodosCampos(Pessoa pessoa) {
		validarObjetoNulo(pessoa);
		validarEmail(pessoa.getEmail());
		validarRegistroAluno(pessoa.getRegistroAluno());
		if (pessoa instanceof PessoaFisica pf) { 
			
		} else if (pessoa instanceof PessoaJuridica pj) { 
			
		}
	}
	
	private static void validarObjetoNulo(Pessoa pessoa) {
		if (pessoa == null) {
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
	
	private static void validarEmail(String email) {
		if (email == null) {
			throw new ValidacaoExcecao("O campo E-mail é obrigatório o preenchimento.");
		} else if (email.isBlank()) {
			throw new ValidacaoExcecao("O campo E-mail é obrigatório o preenchimento.");
		} else if (email.isEmpty()) {
			throw new ValidacaoExcecao("O campo E-mail é obrigatório o preenchimento.");
		} else if (email.length() > 120) {
			throw new ValidacaoExcecao("O campo E-mail deve conter 8 caracteres.");
		}	
	}
}

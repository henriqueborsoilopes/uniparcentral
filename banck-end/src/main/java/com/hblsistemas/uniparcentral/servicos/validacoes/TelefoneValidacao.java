package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.entidades.Telefone;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperadora;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

import jakarta.persistence.ManyToOne;

public class TelefoneValidacao {
	
	@ManyToOne
	private Agencia titularAgencia;
	
	@ManyToOne
	private Pessoa titularPessoa;
	
	public static void validarTodosCampos(Telefone telefone) {
		validarObjetoNulo(telefone);
		validarRegistroAluno(telefone.getRegistroAluno());
		validarTelNumero(telefone.getNumero());
		validarTipoOperadora(telefone.getTipoOperadora());
		validarTitularAgencia(telefone.getTitularAgencia());
		validarTitularPessoa(telefone.getTitularPessoa());
	}
	
	private static void validarObjetoNulo(Telefone telefone) {
		if (telefone == null) {
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
	
	private static void validarTipoOperadora(TipoOperadora tipoOperadora) {
		if (tipoOperadora == null) {
			throw new ValidacaoExcecao("O campo Tipo Operadora é obrigatório o preenchimento.");
		}	
	}
	
	private static void validarTitularAgencia(Agencia agencia) {
		if (agencia == null) {
			throw new ValidacaoExcecao("O compo Agencia é obrigatório o preenchimento");
		}
	}
	
	private static void validarTitularPessoa(Pessoa pessoa) {
		if (pessoa == null) {
			throw new ValidacaoExcecao("O compo Pessoa é obrigatório o preenchimento");
		}
	}
}

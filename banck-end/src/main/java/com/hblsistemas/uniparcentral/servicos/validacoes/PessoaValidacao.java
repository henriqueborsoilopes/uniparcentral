package com.hblsistemas.uniparcentral.servicos.validacoes;

import java.time.LocalDateTime;

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
			validarNome(pf.getNome());
			validarCpf(pf.getCpf());
			validarRg(pf.getRg());
			validarDataNascimento(pf.getDataNascimento());
		} else if (pessoa instanceof PessoaJuridica pj) { 
			validarRasaoSocial(pj.getCnpj());
			validarCnpj(pj.getCnpj());
			validarCnaePrincipal(pj.getCnaePrincipal());
			validarNomeFantasia(pj.getNomeFantasia());
		}
	}
	
	private static void validarObjetoNulo(Pessoa pessoa) {
		if (pessoa == null) {
			throw new ValidacaoExcecao("Os dados do Banco são obrigatório o preenchimento.");
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
	
	private static void validarEmail(String email) {
		if (email == null || email.isBlank() || email.isEmpty()) {
			throw new ValidacaoExcecao("O campo E-mail é obrigatório o preenchimento.");
		} else if (email.length() > 120) {
			throw new ValidacaoExcecao("O campo E-mail deve conter no máximo 120 caracteres.");
		}	
	}
	
	private static void validarNome(String nome) {
		if (nome == null || nome.isBlank() || nome.isEmpty()) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (nome.length() > 120) {
			throw new ValidacaoExcecao("O campo Nome deve conter 120 caracteres.");
		}	
	}
	
	private static void validarCpf(String cpf) {
		if (cpf == null || cpf.isBlank() || cpf.isEmpty()) {
			throw new ValidacaoExcecao("O campo CPF é obrigatório o preenchimento.");
		} else if (cpf.length() < 11) {
			throw new ValidacaoExcecao("O campo CPF deve conter no mínimo 11 caracteres.");
		} else if (cpf.length() > 11) {
			throw new ValidacaoExcecao("O campo CPF deve conter no máximo 11 caracteres.");
		}
	}
	
	private static void validarRg(String rg) {
		if (rg == null || rg.isBlank() || rg.isEmpty()) {
			throw new ValidacaoExcecao("O campo RG é obrigatório o preenchimento.");
		} else if (rg.length() < 7) {
			throw new ValidacaoExcecao("O campo RG deve conter no mínimo 7 caracteres.");
		} else if (rg.length() > 7) {
			throw new ValidacaoExcecao("O campo RG deve conter no máximo 7 caracteres.");
		}
	}
	
	private static void validarDataNascimento(LocalDateTime dataNascimento) {
		if (dataNascimento == null) {
			throw new ValidacaoExcecao("O campo Data de Nascimento é obrigatório o preenchimento.");
		}
	}
	
	private static void validarRasaoSocial(String razaoSocial) {
		if (razaoSocial == null || razaoSocial.isBlank() || razaoSocial.isEmpty()) {
			throw new ValidacaoExcecao("O campo Razão Social é obrigatório o preenchimento.");
		} else if (razaoSocial.length() > 120) {
			throw new ValidacaoExcecao("O campo Razão Social deve conter 120 caracteres.");
		}	
	}
	
	private static void validarCnpj(String cnpj) {
		if (cnpj == null || cnpj.isBlank() || cnpj.isEmpty()) {
			throw new ValidacaoExcecao("O campo CNPJ é obrigatório o preenchimento.");
		} else if (cnpj.length() < 14) {
			throw new ValidacaoExcecao("O campo CNPJ deve conter no mínimo 14 caracteres.");
		} else if (cnpj.length() > 14) {
			throw new ValidacaoExcecao("O campo CNPJ deve conter no máximo 14 caracteres.");
		}
	}
	
	private static void validarCnaePrincipal(String cnaePrincipal) {
		if (cnaePrincipal == null || cnaePrincipal.isBlank() || cnaePrincipal.isEmpty()) {
			throw new ValidacaoExcecao("O campo CNAE Principal é obrigatório o preenchimento.");
		} else if (cnaePrincipal.length() < 7) {
			throw new ValidacaoExcecao("O campo CNAE Principal deve conter no mínimo 7 caracteres.");
		} else if (cnaePrincipal.length() > 7) {
			throw new ValidacaoExcecao("O campo CNAE Principal deve conter no máximo 7 caracteres.");
		}
	}
	
	private static void validarNomeFantasia(String nomeFantasia) {
		if (nomeFantasia == null || nomeFantasia.isBlank() || nomeFantasia.isEmpty()) {
			throw new ValidacaoExcecao("O campo Nome Fantasia é obrigatório o preenchimento.");
		} else if (nomeFantasia.length() > 120) {
			throw new ValidacaoExcecao("O campo Nome Fantasia deve conter 120 caracteres.");
		}	
	}
}

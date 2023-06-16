package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.entidades.Endereco;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class EnderecoValidacao {
		
	public static void validarTodosCampos(Endereco endereco) {
		validarObjetoNulo(endereco);
		validarRegistroAluno(endereco.getRegistroAluno());
		validarLougradouro(endereco.getLogradouro());
		validarCidade(endereco.getCidade());
		validarMorador(endereco.getMorador());
		validarEndNumero(endereco.getNumero());
		validarBairro(endereco.getBairro());
		validarCep(endereco.getCep());
		validarComplemento(endereco.getComplemento());
	}
	
	private static void validarObjetoNulo(Endereco endereco) {
		if (endereco == null) {
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
	
	private static void validarLougradouro(String lougradouro) {
		if (lougradouro == null) {
			throw new ValidacaoExcecao("O campo Lougradouro é obrigatório o preenchimento.");
		} else if (lougradouro.isBlank()) {
			throw new ValidacaoExcecao("O campo Lougradouro é obrigatório o preenchimento.");
		} else if (lougradouro.isEmpty()) {
			throw new ValidacaoExcecao("O campo Lougradouro é obrigatório o preenchimento.");
		} else if (lougradouro.length() > 120) {
			throw new ValidacaoExcecao("O campo Lougradouro deve conter 120 caracteres.");
		}	
	}
	
	private static void validarEndNumero(String numero) {
		if (numero == null) {
			throw new ValidacaoExcecao("O campo Número do Endereço é obrigatório o preenchimento.");
		} else if (numero.isBlank()) {
			throw new ValidacaoExcecao("O campo Número do Endereço é obrigatório o preenchimento.");
		} else if (numero.isEmpty()) {
			throw new ValidacaoExcecao("O campo Número do Endereço é obrigatório o preenchimento.");
		} else if (numero.length() > 120) {
			throw new ValidacaoExcecao("O campo Número do Endereço deve conter 120 caracteres.");
		}
	}
	
	private static void validarBairro(String bairro) {
		if (bairro == null) {
			throw new ValidacaoExcecao("O campo Bairro é obrigatório o preenchimento.");
		} else if (bairro.isBlank()) {
			throw new ValidacaoExcecao("O campo Bairro é obrigatório o preenchimento.");
		} else if (bairro.isEmpty()) {
			throw new ValidacaoExcecao("O campo Bairro é obrigatório o preenchimento.");
		} else if (bairro.length() > 120) {
			throw new ValidacaoExcecao("O campo Bairro deve conter 120 caracteres.");
		}
	}
	
	private static void validarCep(String cep) {
		if (cep == null) {
			throw new ValidacaoExcecao("O campo CEP é obrigatório o preenchimento.");
		} else if (cep.isBlank()) {
			throw new ValidacaoExcecao("O campo CEP é obrigatório o preenchimento.");
		} else if (cep.isEmpty()) {
			throw new ValidacaoExcecao("O campo CEP é obrigatório o preenchimento.");
		} else if (cep.length() > 120) {
			throw new ValidacaoExcecao("O campo CEP deve conter 120 caracteres.");
		}
	}
	
	private static void validarComplemento(String complemento) {
		if (complemento == null) {
			throw new ValidacaoExcecao("O campo Complemento é obrigatório o preenchimento.");
		} else if (complemento.isBlank()) {
			throw new ValidacaoExcecao("O campo Complemento é obrigatório o preenchimento.");
		} else if (complemento.isEmpty()) {
			throw new ValidacaoExcecao("O campo Complemento é obrigatório o preenchimento.");
		} else if (complemento.length() > 120) {
			throw new ValidacaoExcecao("O campo Complemento deve conter 120 caracteres.");
		}
	}
	
	private static void validarMorador(Pessoa pessoa) {
		if (pessoa == null) {
			throw new ValidacaoExcecao("O campo Pessoa é obrigatório o preenchimento.");
		}
	}
	
	private static void validarCidade(Cidade cidade) {
		if (cidade == null) {
			throw new ValidacaoExcecao("O campo Cidade é obrigatório o preenchimento.");
		}
	}
}

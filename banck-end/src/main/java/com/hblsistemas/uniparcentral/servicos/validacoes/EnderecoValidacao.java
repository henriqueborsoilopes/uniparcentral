package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.dtos.requests.EnderecoRequest;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class EnderecoValidacao {
		
	public static void validarTodosCampos(EnderecoRequest request) {
		validarObjetoNulo(request);
		validarRegistroAluno(request.getRegistroAluno());
		validarLougradouro(request.getLogradouro());
		validarCidadeId(request.getCidade_id());
		validarMoradorId(request.getMorador_id());
		validarEndNumero(request.getNumero());
		validarBairro(request.getBairro());
		validarCep(request.getCep());
		validarComplemento(request.getComplemento());
	}
	
	private static void validarObjetoNulo(EnderecoRequest request) {
		if (request == null) {
			throw new ValidacaoExcecao("É obrigatório que um Endereço seja válido!");
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
	
	private static void validarLougradouro(String lougradouro) {
		if (lougradouro == null || lougradouro.isBlank() || lougradouro.isEmpty()) {
			throw new ValidacaoExcecao("O campo Lougradouro é obrigatório o preenchimento.");
		} else if (lougradouro.length() > 120) {
			throw new ValidacaoExcecao("O campo Lougradouro deve conter no máximo 120 caracteres.");
		}	
	}
	
	private static void validarEndNumero(String numero) {
		if (numero == null || numero.isBlank() || numero.isEmpty()) {
			throw new ValidacaoExcecao("O campo Número do Endereço é obrigatório o preenchimento.");
		} else if (numero.length() > 120) {
			throw new ValidacaoExcecao("O campo Número do Endereço deve conter no máximo 120 caracteres.");
		}
	}
	
	private static void validarBairro(String bairro) {
		if (bairro == null || bairro.isBlank() || bairro.isEmpty()) {
			throw new ValidacaoExcecao("O campo Bairro é obrigatório o preenchimento.");
		} else if (bairro.length() > 120) {
			throw new ValidacaoExcecao("O campo Bairro deve conter no máximo 120 caracteres.");
		}
	}
	
	private static void validarCep(String cep) {
		if (cep == null || cep.isBlank() || cep.isEmpty()) {
			throw new ValidacaoExcecao("O campo CEP é obrigatório o preenchimento.");
		} else if (cep.length() > 120) {
			throw new ValidacaoExcecao("O campo CEP deve conter no máximo 120 caracteres.");
		}
	}
	
	private static void validarComplemento(String complemento) {
		if (complemento == null || complemento.isBlank() || complemento.isEmpty()) {
			throw new ValidacaoExcecao("O campo Complemento é obrigatório o preenchimento.");
		} else if (complemento.length() > 120) {
			throw new ValidacaoExcecao("O campo Complemento deve conter no máximo 120 caracteres.");
		}
	}
	
	private static void validarMoradorId(Long moradorId) {
		if (moradorId == null) {
			throw new ValidacaoExcecao("O campo Pessoa é obrigatório o preenchimento.");
		}
	}
	
	private static void validarCidadeId(Long cidadeId) {
		if (cidadeId == null) {
			throw new ValidacaoExcecao("O campo Cidade é obrigatório o preenchimento.");
		}
	}
}

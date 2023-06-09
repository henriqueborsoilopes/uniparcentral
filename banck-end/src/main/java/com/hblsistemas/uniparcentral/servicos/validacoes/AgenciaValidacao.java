package com.hblsistemas.uniparcentral.servicos.validacoes;

import com.hblsistemas.uniparcentral.dtos.requests.AgenciaRequest;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

public class AgenciaValidacao {
		
	public static void validarTodosCamposParaInserir(AgenciaRequest agenciaDTO) {
		validarTodosCamposParaUpdate(agenciaDTO);
		validarBancoId(agenciaDTO.getBanco_id());
		validarCodigo(agenciaDTO.getCodigo());
		validarDigito(agenciaDTO.getDigito());
		validarCnpj(agenciaDTO.getCnpj());
	}
	
	public static void validarTodosCamposParaUpdate(AgenciaRequest agenciaDTO) {
		validarObjetoNulo(agenciaDTO);
		validarRazaosocial(agenciaDTO.getRazaoSocial());
		validarRegistroAluno(agenciaDTO.getRegistroAluno());
	}
	
	private static void validarObjetoNulo(AgenciaRequest agenciaDTO) {
		if (agenciaDTO == null) {
			throw new ValidacaoExcecao("É obrigatório que um Agencia seja válido!");
		}
	}
	
	private static void validarCodigo(String codigo) {
		if (codigo == null || codigo.isBlank() || codigo.isEmpty()) {
			throw new ValidacaoExcecao("O campo Código é obrigatório o preenchimento.");
		} else if (codigo.length() < 8) {
			throw new ValidacaoExcecao("O campo Código deve conter 8 caracteres.");
		} else if (codigo.length() > 8) {
			throw new ValidacaoExcecao("O campo Código deve conter 8 caracteres.");
		}
	}
	
	private static void validarDigito(String digito) {
		if (digito == null || digito.isBlank() || digito.isEmpty()) {
			throw new ValidacaoExcecao("O campo Digito é obrigatório o preenchimento.");
		} else if (digito.length() < 2) {
			throw new ValidacaoExcecao("O campo Digito deve conter 8 caracteres.");
		} else if (digito.length() > 2) {
			throw new ValidacaoExcecao("O campo Digito deve conter 8 caracteres.");
		}
	}
	
	private static void validarCnpj(String cnpj) {
		if (cnpj == null || cnpj.isBlank() || cnpj.isEmpty()) {
			throw new ValidacaoExcecao("O campo CNPJ é obrigatório o preenchimento.");
		} else if (cnpj.length() < 14) {
			throw new ValidacaoExcecao("O campo CNPJ deve conter 8 caracteres.");
		} else if (cnpj.length() > 14) {
			throw new ValidacaoExcecao("O campo CNPJ deve conter 8 caracteres.");
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
	
	private static void validarRazaosocial(String razaosocial) {
		if (razaosocial == null || razaosocial.isBlank() || razaosocial.isEmpty()) {
			throw new ValidacaoExcecao("O campo Nome é obrigatório o preenchimento.");
		} else if (razaosocial.length() > 120) {
			throw new ValidacaoExcecao("O campo Nome deve conter 8 caracteres.");
		}	
	}
	
	private static void validarBancoId(Long bancoId) {
		if (bancoId == null) {
			throw new ValidacaoExcecao("É obrigatório que um País seja válido!");
		}
	}
}

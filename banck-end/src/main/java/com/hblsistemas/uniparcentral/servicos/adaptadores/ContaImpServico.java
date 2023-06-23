package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.ContaRequest;
import com.hblsistemas.uniparcentral.dtos.responses.ContaResponse;
import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperacao;
import com.hblsistemas.uniparcentral.modelmapper.ContaMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.ContaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.ContaPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.ContaValidacao;

@Service
public class ContaImpServico implements ContaPortaServico {
	
	private final ContaPortaRepositorio contaRepositorioPorta;
	private final ContaMapper mapper;
	
	public ContaImpServico(ContaPortaRepositorio contaRepositorioPorta, ContaMapper mapper) {
		this.contaRepositorioPorta = contaRepositorioPorta;
		this.mapper = mapper;
	}
	
	@Override
	public ContaResponse inserir(ContaRequest request) {
		ContaValidacao.validarTodosCampos(request);
		return mapper.paraResposta(contaRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<ContaResponse> acharTodos() {
		return mapper.paraRespostaLista(contaRepositorioPorta.acharTodos());
	}
	
	@Override
	public ContaResponse acharPorId(Long id) {
		return mapper.paraResposta(contaRepositorioPorta.acharPorId(id));
	}
	
	@Override
	public void atualizarSaldo(Long id, Double saldo, TipoOperacao operacao) {
		ContaValidacao.validarSaldo(saldo);
		Conta conta = contaRepositorioPorta.acharPorId(id);
		switch (operacao) {
		case ENTRADA:
			saldo = conta.getSaldo() + saldo;
			break;
		case SAIDA:
			saldo = conta.getSaldo() - saldo;
			break;
		}
		contaRepositorioPorta.atualizarSaldo(saldo, id);
	}
	
	@Override
	public void deletar(Long id) {
		contaRepositorioPorta.deletar(id);
	}
}

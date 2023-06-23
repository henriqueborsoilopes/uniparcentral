package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.TransacaoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.TransacaoResponse;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperacao;
import com.hblsistemas.uniparcentral.modelmapper.TransacaoMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.TransacaoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.TransacaoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.TransacaoValidacao;

@Service
public class TransacaoImpServico implements TransacaoPortaServico {
	
	private final TransacaoPortaRepositorio transacaoRepositorioPorta;
	private final TransacaoMapper mapper;
	private final ContaImpServico contaServico;
	
	public TransacaoImpServico(TransacaoPortaRepositorio transacaoRepositorioPorta, ContaImpServico contaServico, TransacaoMapper mapper) {
		this.transacaoRepositorioPorta = transacaoRepositorioPorta;
		this.contaServico = contaServico;
		this.mapper = mapper;
	}
	
	@Override
	public TransacaoResponse inserir(TransacaoRequest request) {
		TransacaoValidacao.validarTodosCampos(request);
		contaServico.atualizarSaldo(request.getId(), request.getValor(), TipoOperacao.SAIDA);
		contaServico.atualizarSaldo(request.getId(), request.getValor(), TipoOperacao.ENTRADA);
		return mapper.paraResposta(transacaoRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<TransacaoResponse> acharTodos(Long conta_id) {
		return  mapper.paraRespostaLista(transacaoRepositorioPorta.acharTodos(conta_id));
	}
}

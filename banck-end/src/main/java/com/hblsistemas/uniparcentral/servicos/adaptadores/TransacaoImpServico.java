package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Transacao;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperacao;
import com.hblsistemas.uniparcentral.repositorios.portas.TransacaoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.TransacaoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.TransacaoValidacao;

@Service
public class TransacaoImpServico implements TransacaoPortaServico {
	
	private final TransacaoPortaRepositorio transacaoRepositorioPorta;
	private final ContaImpServico contaServico;
	
	public TransacaoImpServico(TransacaoPortaRepositorio transacaoRepositorioPorta, ContaImpServico contaServico) {
		this.transacaoRepositorioPorta = transacaoRepositorioPorta;
		this.contaServico = contaServico;
	}
	
	@Override
	public Transacao inserir(Transacao transacao) {
		TransacaoValidacao.validarTodosCampos(transacao);
		contaServico.atualizarSaldo(transacao.getContaOrigem().getId(), transacao.getValor(), TipoOperacao.SAIDA);
		contaServico.atualizarSaldo(transacao.getContaDestino().getId(), transacao.getValor(), TipoOperacao.ENTRADA);
		return transacaoRepositorioPorta.inserir(transacao);
	}
	
	@Override
	public List<Transacao> acharTodos(Long conta_id) {
		return transacaoRepositorioPorta.acharTodos(conta_id);
	}
}

package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Transacao;
import com.hblsistemas.uniparcentral.repositorios.portas.TransacaoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.TransacaoValidacao;

@Service
public class TransacaoServico {
	
	private final TransacaoPortaRepositorio transacaoRepositorioPorta;
	private final ContaServico contaServico;
	
	public TransacaoServico(TransacaoPortaRepositorio transacaoRepositorioPorta, ContaServico contaServico) {
		this.transacaoRepositorioPorta = transacaoRepositorioPorta;
		this.contaServico = contaServico;
	}
	
	public void inserir(Transacao transacao) {
		TransacaoValidacao.validarTodosCampos(transacao);
		contaServico.atualizar(null, null);
		transacaoRepositorioPorta.inserir(transacao);
	}
	
	public List<Transacao> acharTodos() {
		return transacaoRepositorioPorta.acharTodos();
	}
	
	public Transacao acharPorId(Long id) {
		return transacaoRepositorioPorta.acharPorId(id);
	}
}

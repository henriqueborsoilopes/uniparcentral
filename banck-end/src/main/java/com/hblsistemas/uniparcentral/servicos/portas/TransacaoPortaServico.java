package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Transacao;

public interface TransacaoPortaServico {
	
	public Transacao inserir(Transacao transacao);
	public List<Transacao> acharTodos();
	public Transacao acharPorId(Long id);
}

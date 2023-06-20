package com.hblsistemas.uniparcentral.repositorios.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Transacao;

public interface TransacaoPortaRepositorio {
	
	public Transacao inserir(Transacao transacao);
	public List<Transacao> acharTodos(Long conta_id);
}

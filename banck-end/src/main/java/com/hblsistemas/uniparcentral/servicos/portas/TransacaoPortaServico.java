package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.TransacaoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.TransacaoResponse;

public interface TransacaoPortaServico {
	
	public TransacaoResponse inserir(TransacaoRequest transacao);
	public List<TransacaoResponse> acharTodos(Long conta_id);
}

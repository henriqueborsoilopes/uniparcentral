package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.AgenciaRequest;
import com.hblsistemas.uniparcentral.dtos.responses.AgenciaResponse;

public interface AgenciaPortaServico {
	
	public AgenciaResponse inserir(AgenciaRequest agencia);
	public List<AgenciaResponse> acharTodos();
	public AgenciaResponse acharPorId(Long id);
	public void atualizar(AgenciaRequest agencia, Long id);
	public void deletar(Long id);
}

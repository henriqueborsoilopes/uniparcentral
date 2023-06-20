package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.AgenciaRequest;

public interface AgenciaPortaServico {
	
	public AgenciaRequest inserir(AgenciaRequest agencia);
	public List<AgenciaRequest> acharTodos();
	public AgenciaRequest acharPorId(Long id);
	public void atualizar(AgenciaRequest agenciaDTO, Long id);
	public void deletar(Long id);
}

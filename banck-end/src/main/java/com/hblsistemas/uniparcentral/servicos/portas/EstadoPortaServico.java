package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.EstadoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.EstadoResponse;

public interface EstadoPortaServico {
	
	public EstadoResponse inserir(EstadoRequest estado);
	public List<EstadoResponse> acharTodos();
	public EstadoResponse acharPorId(Long id);
	public void atualizar(EstadoRequest estado, Long id);
	public void deletar(Long id);
}

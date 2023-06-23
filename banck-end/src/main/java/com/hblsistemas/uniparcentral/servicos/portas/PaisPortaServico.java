package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.PaisRequest;
import com.hblsistemas.uniparcentral.dtos.responses.PaisResponse;

public interface PaisPortaServico {
	
	public PaisResponse inserir(PaisRequest pais);
	public List<PaisResponse> acharTodos();
	public PaisResponse acharPorId(Long id);
	public void atualizar(PaisRequest pais, Long id);
	public void deletar(Long id);
}

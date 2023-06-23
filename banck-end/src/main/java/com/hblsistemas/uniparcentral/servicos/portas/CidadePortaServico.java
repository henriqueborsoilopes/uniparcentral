package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.CidadeRequest;
import com.hblsistemas.uniparcentral.dtos.responses.CidadeResponse;

public interface CidadePortaServico {
	
	public CidadeResponse inserir(CidadeRequest cidade);
	public List<CidadeResponse> acharTodos();
	public CidadeResponse acharPorId(Long id);
	public void atualizar(CidadeRequest cidade, Long id);
	public void deletar(Long id);
}

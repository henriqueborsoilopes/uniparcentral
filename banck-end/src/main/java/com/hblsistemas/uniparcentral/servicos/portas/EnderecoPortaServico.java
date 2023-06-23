package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.EnderecoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.EnderecoResponse;

public interface EnderecoPortaServico {
	
	public EnderecoResponse inserir(EnderecoRequest endereco);
	public List<EnderecoResponse> acharTodos();
	public EnderecoResponse acharPorId(Long id);
	public void atualizar(EnderecoRequest endereco, Long id);
	public void deletar(Long id);
}

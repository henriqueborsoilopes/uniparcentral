package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.BancoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.BancoResponse;

public interface BancoPortaServico {
	
	public BancoResponse inserir(BancoRequest banco);
	public List<BancoResponse> acharTodos();
	public BancoResponse acharPorId(Long id);
	public void atualizar(BancoRequest banco, Long id);
	public void deletar(Long id);
}

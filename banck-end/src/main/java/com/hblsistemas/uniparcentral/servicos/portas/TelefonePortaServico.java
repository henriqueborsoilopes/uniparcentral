package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.TelefoneRequest;
import com.hblsistemas.uniparcentral.dtos.responses.TelefoneResponse;

public interface TelefonePortaServico {
	
	public TelefoneResponse inserir(TelefoneRequest telefone);
	public List<TelefoneResponse> acharTodos();
	public TelefoneResponse acharPorId(Long id);
	public void atualizar(TelefoneRequest telefone, Long id);
	public void deletar(Long id);
}

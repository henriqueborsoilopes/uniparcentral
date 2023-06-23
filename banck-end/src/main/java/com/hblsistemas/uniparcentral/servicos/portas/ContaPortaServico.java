package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.requests.ContaRequest;
import com.hblsistemas.uniparcentral.dtos.responses.ContaResponse;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperacao;

public interface ContaPortaServico {
	
	public ContaResponse inserir(ContaRequest conta);
	public List<ContaResponse> acharTodos();
	public ContaResponse acharPorId(Long id);
	public void atualizarSaldo(Long id, Double saldo, TipoOperacao operacao);
	public void deletar(Long id);
}

package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Agencia;

public interface AgenciaPortaServico {
	
	public Agencia inserir(Agencia agencia);
	public List<Agencia> acharTodos();
	public Agencia acharPorId(Long id);
	public void atualizar(Agencia agencia, Long id);
	public void deletar(Long id);
}

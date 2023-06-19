package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Estado;

public interface EstadoPortaServico {
	
	public Estado inserir(Estado estado);
	public List<Estado> acharTodos();
	public Estado acharPorId(Long id);
	public void atualizar(Estado estado, Long id);
	public void deletar(Long id);
}

package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Pais;

public interface PaisPortaServico {
	
	public Pais inserir(Pais pais);
	public List<Pais> acharTodos();
	public Pais acharPorId(Long id);
	public void atualizar(Pais pais, Long id);
	public void deletar(Long id);
}

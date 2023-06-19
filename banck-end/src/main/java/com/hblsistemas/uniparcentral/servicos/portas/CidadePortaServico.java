package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Cidade;

public interface CidadePortaServico {
	
	public Cidade inserir(Cidade cidade);
	public List<Cidade> acharTodos();
	public Cidade acharPorId(Long id);
	public void atualizar(Cidade cidade, Long id);
	public void deletar(Long id);
}

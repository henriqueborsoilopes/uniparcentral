package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;

public interface PessoaPortaServico {
	
	public Pessoa inserir(Pessoa pessoa);
	public List<Pessoa> acharTodos();
	public Pessoa acharPorId(Long id);
	public void atualizar(Pessoa pessoa, Long id);
	public void deletar(Long id);
}

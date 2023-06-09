package com.hblsistemas.uniparcentral.repositorios.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Telefone;

public interface TelefonePortaRepositorio {
	
	public Telefone inserir(Telefone pessoa);
	public List<Telefone> acharTodos();
	public Telefone acharPorId(Long id);
	public void atualizar(Telefone telefone, Long id);
	public void deletar(Long id);
}

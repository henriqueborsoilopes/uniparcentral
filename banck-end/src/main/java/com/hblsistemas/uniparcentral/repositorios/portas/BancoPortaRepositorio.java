package com.hblsistemas.uniparcentral.repositorios.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Banco;

public interface BancoPortaRepositorio {
	
	public Banco inserir(Banco banco);
	public List<Banco> acharTodos();
	public Banco acharPorId(Long id);
	public void atualizar(Banco banco, Long id);
	public void deletar(Long id);
}

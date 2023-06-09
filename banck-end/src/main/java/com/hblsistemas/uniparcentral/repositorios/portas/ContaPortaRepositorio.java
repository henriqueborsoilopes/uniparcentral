package com.hblsistemas.uniparcentral.repositorios.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Conta;

public interface ContaPortaRepositorio {
	
	public Conta inserir(Conta conta);
	public List<Conta> acharTodos();
	public Conta acharPorId(Long id);
	public void atualizar(Conta conta, Long id);
	public void deletar(Long id);
}

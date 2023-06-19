package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Conta;

public interface ContaPortaServico {
	
	public Conta inserir(Conta conta);
	public List<Conta> acharTodos();
	public Conta acharPorId(Long id);
	public void atualizarSaldo(Double saldo, Long id);
	public void deletar(Long id);
}

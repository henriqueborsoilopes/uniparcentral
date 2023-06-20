package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperacao;

public interface ContaPortaServico {
	
	public Conta inserir(Conta conta);
	public List<Conta> acharTodos();
	public Conta acharPorId(Long id);
	public void atualizarSaldo(Long id, Double saldo, TipoOperacao operacao);
	public void deletar(Long id);
}

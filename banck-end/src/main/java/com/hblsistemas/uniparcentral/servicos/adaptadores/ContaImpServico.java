package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperacao;
import com.hblsistemas.uniparcentral.repositorios.portas.ContaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.ContaValidacao;

@Service
public class ContaImpServico {
	
	private final ContaPortaRepositorio contaRepositorioPorta;
	
	public ContaImpServico(ContaPortaRepositorio contaRepositorioPorta) {
		this.contaRepositorioPorta = contaRepositorioPorta;
	}
	
	public void inserir(Conta conta) {
		ContaValidacao.validarTodosCampos(conta);
		contaRepositorioPorta.inserir(conta);
	}
	
	public List<Conta> acharTodos() {
		return contaRepositorioPorta.acharTodos();
	}
	
	public Conta acharPorId(Long id) {
		return contaRepositorioPorta.acharPorId(id);
	}
	
	public void atualizarSaldo(Long id, Double saldo, TipoOperacao operacao) {
		ContaValidacao.validarSaldo(saldo);
		Conta conta = acharPorId(id);
		switch (operacao) {
		case ENTRADA:
			conta.setSaldo(conta.getSaldo() + saldo);
			break;
		case SAIDA:
			conta.setSaldo(conta.getSaldo() - saldo);
			break;
		}
		contaRepositorioPorta.atualizarSaldo(saldo, id);
	}
	
	public void deletar(Long id) {
		contaRepositorioPorta.deletar(id);
	}
}

package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperacao;
import com.hblsistemas.uniparcentral.repositorios.portas.ContaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.ContaPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.ContaValidacao;

@Service
public class ContaImpServico implements ContaPortaServico {
	
	private final ContaPortaRepositorio contaRepositorioPorta;
	
	public ContaImpServico(ContaPortaRepositorio contaRepositorioPorta) {
		this.contaRepositorioPorta = contaRepositorioPorta;
	}
	
	@Override
	public Conta inserir(Conta conta) {
		ContaValidacao.validarTodosCampos(conta);
		return contaRepositorioPorta.inserir(conta);
	}
	
	@Override
	public List<Conta> acharTodos() {
		return contaRepositorioPorta.acharTodos();
	}
	
	@Override
	public Conta acharPorId(Long id) {
		return contaRepositorioPorta.acharPorId(id);
	}
	
	@Override
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
	
	@Override
	public void deletar(Long id) {
		contaRepositorioPorta.deletar(id);
	}
}

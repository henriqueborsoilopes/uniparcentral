package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.repositorios.portas.ContaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.ContaValidacao;

@Service
public class ContaServico {
	
	private final ContaPortaRepositorio contaRepositorioPorta;
	
	public ContaServico(ContaPortaRepositorio contaRepositorioPorta) {
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
	
	public void atualizar(Long id, Conta conta) {
		ContaValidacao.validarTodosCampos(conta);
		contaRepositorioPorta.atualizar(conta, id);
	}
	
	public void deletar(Long id) {
		contaRepositorioPorta.deletar(id);
	}
}

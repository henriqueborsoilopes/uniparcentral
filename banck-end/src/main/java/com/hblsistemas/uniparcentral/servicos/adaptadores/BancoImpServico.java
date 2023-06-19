package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Banco;
import com.hblsistemas.uniparcentral.repositorios.portas.BancoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.BancoValidacao;

@Service
public class BancoImpServico {
	
	private final BancoPortaRepositorio bancoRepositorioPorta;
	
	public BancoImpServico(BancoPortaRepositorio bancoRepositorioPorta) {
		this.bancoRepositorioPorta = bancoRepositorioPorta;
	}
	
	public void inserir(Banco banco) {
		BancoValidacao.validarTodosCampos(banco);
		bancoRepositorioPorta.inserir(banco);
	}
	
	public List<Banco> acharTodos() {
		return bancoRepositorioPorta.acharTodos();
	}
	
	public Banco acharPorId(Long id) {
		return bancoRepositorioPorta.acharPorId(id);
	}
	
	public void atualizar(Long id, Banco banco) {
		BancoValidacao.validarTodosCampos(banco);
		bancoRepositorioPorta.atualizar(banco, id);
	}
	
	public void deletar(Long id) {
		bancoRepositorioPorta.deletar(id);
	}
}

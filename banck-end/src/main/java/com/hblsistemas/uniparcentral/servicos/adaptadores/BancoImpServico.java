package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Banco;
import com.hblsistemas.uniparcentral.repositorios.portas.BancoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.BancoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.BancoValidacao;

@Service
public class BancoImpServico implements BancoPortaServico {
	
	private final BancoPortaRepositorio bancoRepositorioPorta;
	
	public BancoImpServico(BancoPortaRepositorio bancoRepositorioPorta) {
		this.bancoRepositorioPorta = bancoRepositorioPorta;
	}
	
	@Override
	public Banco inserir(Banco banco) {
		BancoValidacao.validarTodosCampos(banco);
		return bancoRepositorioPorta.inserir(banco);
	}
	
	@Override
	public List<Banco> acharTodos() {
		return bancoRepositorioPorta.acharTodos();
	}
	
	@Override
	public Banco acharPorId(Long id) {
		return bancoRepositorioPorta.acharPorId(id);
	}
	
	@Override
	public void atualizar(Banco banco, Long id) {
		BancoValidacao.validarTodosCampos(banco);
		bancoRepositorioPorta.atualizar(banco, id);
	}
	
	@Override
	public void deletar(Long id) {
		bancoRepositorioPorta.deletar(id);
	}
}

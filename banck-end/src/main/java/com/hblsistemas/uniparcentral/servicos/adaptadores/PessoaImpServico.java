package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.repositorios.portas.PessoaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.PessoaPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.PessoaValidacao;

@Service
public class PessoaImpServico implements PessoaPortaServico {
	
	private final PessoaPortaRepositorio pessoaRepositorioPorta;
	
	public PessoaImpServico(PessoaPortaRepositorio pessoaRepositorioPorta) {
		this.pessoaRepositorioPorta = pessoaRepositorioPorta;
	}
	
	@Override
	public Pessoa inserir(Pessoa pessoa) {
		PessoaValidacao.validarTodosCampos(pessoa);
		return pessoaRepositorioPorta.inserir(pessoa);
	}
	
	@Override
	public List<Pessoa> acharTodos() {
		return pessoaRepositorioPorta.acharTodos();
	}
	
	@Override
	public Pessoa acharPorId(Long id) {
		return pessoaRepositorioPorta.acharPorId(id);
	}
	
	@Override
	public void atualizar(Pessoa pessoa, Long id) {
		PessoaValidacao.validarTodosCampos(pessoa);
		pessoaRepositorioPorta.atualizar(pessoa, id);
	}
	
	@Override
	public void deletar(Long id) {
		pessoaRepositorioPorta.deletar(id);
	}
}

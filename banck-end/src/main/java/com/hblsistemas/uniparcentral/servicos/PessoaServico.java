package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.repositorios.portas.PessoaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.PessoaValidacao;

@Service
public class PessoaServico {
	
	private final PessoaPortaRepositorio pessoaRepositorioPorta;
	
	public PessoaServico(PessoaPortaRepositorio pessoaRepositorioPorta) {
		this.pessoaRepositorioPorta = pessoaRepositorioPorta;
	}
	
	public void inserir(Pessoa pessoa) {
		PessoaValidacao.validarTodosCampos(pessoa);
		pessoaRepositorioPorta.inserir(pessoa);
	}
	
	public List<Pessoa> acharTodos() {
		return pessoaRepositorioPorta.acharTodos();
	}
	
	public Pessoa acharPorId(Long id) {
		return pessoaRepositorioPorta.acharPorId(id);
	}
	
	public void atualizar(Long id, Pessoa pessoa) {
		PessoaValidacao.validarTodosCampos(pessoa);
		pessoaRepositorioPorta.atualizar(pessoa, id);
	}
	
	public void deletar(Long id) {
		pessoaRepositorioPorta.deletar(id);
	}
}

package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.repositorios.portas.CidadePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.CidadeValidacao;

@Service
public class CidadeServico {
	
	private final CidadePortaRepositorio cidadeRepositorioPorta;
	
	public CidadeServico(CidadePortaRepositorio cidadeRepositorioPorta) {
		this.cidadeRepositorioPorta = cidadeRepositorioPorta;
	}
	
	public void inserir(Cidade cidade) {
		CidadeValidacao.validarTodosCampos(cidade);
		cidadeRepositorioPorta.inserir(cidade);
	}
	
	public List<Cidade> acharTodos() {
		return cidadeRepositorioPorta.acharTodos();
	}
	
	public Cidade acharPorId(Long id) {
		return cidadeRepositorioPorta.acharPorId(id);
	}
	
	public void atualizar(Long id, Cidade cidade) {
		CidadeValidacao.validarTodosCampos(cidade);
		cidadeRepositorioPorta.atualizar(cidade, id);
	}
	
	public void deletar(Long id) {
		cidadeRepositorioPorta.deletar(id);
	}
}

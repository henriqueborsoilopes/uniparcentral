package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.repositorios.portas.CidadePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.CidadeValidacao;

@Service
public class CidadeServico {
	
	private final CidadePortaRepositorio cidadePortaRepositorio;
	private final EstadoServico estadoServico;
	
	public CidadeServico(CidadePortaRepositorio cidadePortaRepositorio, EstadoServico estadoServico) {
		this.cidadePortaRepositorio = cidadePortaRepositorio;
		this.estadoServico = estadoServico;
	}
	
	public void inserir(Cidade cidade) {
		CidadeValidacao.validarTodosCamposParaInserir(cidade);
		cidadePortaRepositorio.inserir(cidade);
	}
	
	public List<Cidade> acharTodos() {
		return cidadePortaRepositorio.acharTodos();
	}
	
	public Cidade acharPorId(Long id) {
		Cidade cidade = cidadePortaRepositorio.acharPorId(id);
		cidade.setEstado(estadoServico.acharPorId(cidade.getEstado().getId()));
		return cidade;
	}
	
	public void atualizar(Long id, Cidade cidade) {
		CidadeValidacao.validarTodosCamposParaUpdate(cidade);
		cidadePortaRepositorio.atualizar(cidade, id);
	}
	
	public void deletar(Long id) {
		cidadePortaRepositorio.acharPorId(id);
		cidadePortaRepositorio.deletar(id);
	}
}

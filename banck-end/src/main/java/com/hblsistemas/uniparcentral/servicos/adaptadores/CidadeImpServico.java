package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.repositorios.portas.CidadePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.CidadePortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.CidadeValidacao;

@Service
public class CidadeImpServico implements CidadePortaServico {
	
	private final CidadePortaRepositorio cidadePortaRepositorio;
	private final EstadoImpServico estadoServico;
	
	public CidadeImpServico(CidadePortaRepositorio cidadePortaRepositorio, EstadoImpServico estadoServico) {
		this.cidadePortaRepositorio = cidadePortaRepositorio;
		this.estadoServico = estadoServico;
	}
	
	@Override
	public Cidade inserir(Cidade cidade) {
		CidadeValidacao.validarTodosCamposParaInserir(cidade);
		return cidadePortaRepositorio.inserir(cidade);
	}
	
	@Override
	public List<Cidade> acharTodos() {
		return cidadePortaRepositorio.acharTodos();
	}
	
	@Override
	public Cidade acharPorId(Long id) {
		Cidade cidade = cidadePortaRepositorio.acharPorId(id);
		cidade.setEstado(estadoServico.acharPorId(cidade.getEstado().getId()));
		return cidade;
	}
	
	@Override
	public void atualizar(Cidade cidade, Long id) {
		CidadeValidacao.validarTodosCamposParaUpdate(cidade);
		cidadePortaRepositorio.atualizar(cidade, id);
	}
	
	@Override
	public void deletar(Long id) {
		cidadePortaRepositorio.acharPorId(id);
		cidadePortaRepositorio.deletar(id);
	}
}

package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.CidadeRequest;
import com.hblsistemas.uniparcentral.dtos.responses.CidadeResponse;
import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.modelmapper.CidadeMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.CidadePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.CidadePortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.CidadeValidacao;

@Service
public class CidadeImpServico implements CidadePortaServico {
	
	private final CidadePortaRepositorio cidadePortaRepositorio;
	private final CidadeMapper mapper;
	
	public CidadeImpServico(CidadePortaRepositorio cidadePortaRepositorio, CidadeMapper mapper) {
		this.cidadePortaRepositorio = cidadePortaRepositorio;
		this.mapper = mapper;
	}
	
	@Override
	public CidadeResponse inserir(CidadeRequest request) {
		CidadeValidacao.validarTodosCamposParaInserir(request);
		return mapper.paraResposta(cidadePortaRepositorio.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<CidadeResponse> acharTodos() {
		return mapper.paraRespostaLista(cidadePortaRepositorio.acharTodos());
	}
	
	@Override
	public CidadeResponse acharPorId(Long id) {
		Cidade cidade = cidadePortaRepositorio.acharPorId(id);
		return mapper.paraResposta(cidade);
	}
	
	@Override
	public void atualizar(CidadeRequest request, Long id) {
		CidadeValidacao.validarTodosCamposParaUpdate(request);
		cidadePortaRepositorio.atualizar(mapper.paraEntidade(request), id);
	}
	
	@Override
	public void deletar(Long id) {
		cidadePortaRepositorio.acharPorId(id);
		cidadePortaRepositorio.deletar(id);
	}
}

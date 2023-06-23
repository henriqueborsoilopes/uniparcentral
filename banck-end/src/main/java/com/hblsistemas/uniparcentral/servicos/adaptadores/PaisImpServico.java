package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.PaisRequest;
import com.hblsistemas.uniparcentral.dtos.responses.PaisResponse;
import com.hblsistemas.uniparcentral.modelmapper.PaisMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.PaisPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.PaisPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.PaisValidacao;

@Service
public class PaisImpServico implements PaisPortaServico {
	
	private final PaisPortaRepositorio paisRepositorioPorta;
	private final PaisMapper mapper;
	
	public PaisImpServico(PaisPortaRepositorio paisRepositorioPorta, PaisMapper mapper) {
		this.paisRepositorioPorta = paisRepositorioPorta;
		this.mapper = mapper;
	}
	
	@Override
	public PaisResponse inserir(PaisRequest request) {
		PaisValidacao.validarTodosCampos(request);
		return mapper.paraResposta(paisRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<PaisResponse> acharTodos() {
		return mapper.paraRespostaLista(paisRepositorioPorta.acharTodos());
	}
	
	@Override
	public PaisResponse acharPorId(Long id) {
		return mapper.paraResposta(paisRepositorioPorta.acharPorId(id));
	}
	
	@Override
	public void atualizar(PaisRequest request, Long id) {
		PaisValidacao.validarTodosCampos(request);
		paisRepositorioPorta.atualizar(mapper.paraEntidade(request), id);
	}
	
	@Override
	public void deletar(Long id) {
		paisRepositorioPorta.acharPorId(id);
		paisRepositorioPorta.deletar(id);
	}
}

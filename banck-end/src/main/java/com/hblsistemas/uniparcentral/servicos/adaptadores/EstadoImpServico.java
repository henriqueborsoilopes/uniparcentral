package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.EstadoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.EstadoResponse;
import com.hblsistemas.uniparcentral.entidades.Estado;
import com.hblsistemas.uniparcentral.modelmapper.EstadoMapper;
import com.hblsistemas.uniparcentral.modelmapper.PaisMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.EstadoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.EstadoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.EstadoValidacao;

@Service
public class EstadoImpServico implements EstadoPortaServico {

	private final EstadoPortaRepositorio estadoRepositorioPorta;
	private final PaisImpServico paisServico;
	private final EstadoMapper mapper;
	private final PaisMapper paisMapper;
	
	public EstadoImpServico(EstadoPortaRepositorio estadoRepositorioPorta, PaisImpServico paisServico, EstadoMapper mapper, PaisMapper paisMapper) {
		this.estadoRepositorioPorta = estadoRepositorioPorta;
		this.paisServico = paisServico;
		this.mapper = mapper;
		this.paisMapper = paisMapper;
	}
	
	@Override
	public EstadoResponse inserir(EstadoRequest request) {
		EstadoValidacao.validarTodosCamposParaInserir(request);
		return mapper.paraResposta(estadoRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<EstadoResponse> acharTodos() {
		return mapper.paraRespostaLista(estadoRepositorioPorta.acharTodos());
	}
	
	@Override
	public EstadoResponse acharPorId(Long id) {
		Estado estado = estadoRepositorioPorta.acharPorId(id);
		estado.setPais(paisMapper.paraEntidade(paisServico.acharPorId(estado.getId())));
		return mapper.paraResposta(estado);
	}
	
	@Override
	public void atualizar(EstadoRequest request, Long id) {
		EstadoValidacao.validarTodosCamposParaUpdate(request);
		estadoRepositorioPorta.atualizar(mapper.paraEntidade(request), id);
	}
	
	@Override
	public void deletar(Long id) {
		estadoRepositorioPorta.acharPorId(id);
		estadoRepositorioPorta.deletar(id);
	}
}

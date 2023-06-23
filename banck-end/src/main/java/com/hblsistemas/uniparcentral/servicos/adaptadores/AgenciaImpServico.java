package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.AgenciaRequest;
import com.hblsistemas.uniparcentral.dtos.responses.AgenciaResponse;
import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.modelmapper.AgenciaMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.AgenciaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.AgenciaPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.AgenciaValidacao;

@Service
public class AgenciaImpServico implements AgenciaPortaServico {
	
	private final AgenciaPortaRepositorio agenciaRepositorioPorta;
	private final AgenciaMapper mapper;
	
	public AgenciaImpServico(AgenciaPortaRepositorio agenciaRepositorioPorta, AgenciaMapper agenciaModel) {
		this.agenciaRepositorioPorta = agenciaRepositorioPorta;
		this.mapper = agenciaModel;
	}
	
	@Override
	public AgenciaResponse inserir(AgenciaRequest request) {
		AgenciaValidacao.validarTodosCamposParaInserir(request);
		return mapper.paraResposta(agenciaRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<AgenciaResponse> acharTodos() {
		return mapper.paraRespostaLista(agenciaRepositorioPorta.acharTodos());
	}
	
	@Override
	public AgenciaResponse acharPorId(Long id) {
		Agencia agencia = agenciaRepositorioPorta.acharPorId(id);
		return mapper.paraResposta(agencia);
	}
	
	@Override
	public void atualizar(AgenciaRequest agenciaDTO, Long id) {
		AgenciaValidacao.validarTodosCamposParaUpdate(agenciaDTO);
		agenciaRepositorioPorta.atualizar(mapper.paraEntidade(agenciaDTO), id);
	}
	
	@Override
	public void deletar(Long id) {
		agenciaRepositorioPorta.deletar(id);
	}
}

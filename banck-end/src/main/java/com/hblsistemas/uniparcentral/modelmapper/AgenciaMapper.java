package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.AgenciaRequest;
import com.hblsistemas.uniparcentral.dtos.responses.AgenciaResponse;
import com.hblsistemas.uniparcentral.entidades.Agencia;

@Component
public class AgenciaMapper {
	
	private final ModelMapper mapper;
	
	public AgenciaMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Agencia paraEntidade(AgenciaRequest request) {
		return mapper.map(request, Agencia.class);
	}
	
	public AgenciaResponse paraResposta(Agencia entidade) {
		return mapper.map(entidade, AgenciaResponse.class);
	}
	
	public List<AgenciaResponse> paraRespostaLista(List<Agencia> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

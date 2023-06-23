package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.EstadoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.EstadoResponse;
import com.hblsistemas.uniparcentral.entidades.Estado;

@Component
public class EstadoMapper {
	
	private final ModelMapper mapper;
	
	public EstadoMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Estado paraEntidade(EstadoRequest request) {
		return mapper.map(request, Estado.class);
	}
	
	public EstadoResponse paraResposta(Estado entidade) {
		return mapper.map(entidade, EstadoResponse.class);
	}
	
	public List<EstadoResponse> paraRespostaLista(List<Estado> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

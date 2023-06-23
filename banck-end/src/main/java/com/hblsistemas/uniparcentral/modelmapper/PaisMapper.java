package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.PaisRequest;
import com.hblsistemas.uniparcentral.dtos.responses.PaisResponse;
import com.hblsistemas.uniparcentral.entidades.Pais;

@Component
public class PaisMapper {
	
	private final ModelMapper mapper;
	
	public PaisMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Pais paraEntidade(PaisRequest request) {
		return mapper.map(request, Pais.class);
	}
	
	public Pais paraEntidade(PaisResponse response) {
		return mapper.map(response, Pais.class);
	}
	
	public PaisResponse paraResposta(Pais entidade) {
		return mapper.map(entidade, PaisResponse.class);
	}
	
	public List<PaisResponse> paraRespostaLista(List<Pais> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

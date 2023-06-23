package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.CidadeRequest;
import com.hblsistemas.uniparcentral.dtos.responses.CidadeResponse;
import com.hblsistemas.uniparcentral.entidades.Cidade;

@Component
public class CidadeMapper {
	
	private final ModelMapper mapper;
	
	public CidadeMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Cidade paraEntidade(CidadeRequest request) {
		return mapper.map(request, Cidade.class);
	}
	
	public CidadeResponse paraResposta(Cidade entidade) {
		return mapper.map(entidade, CidadeResponse.class);
	}
	
	public List<CidadeResponse> paraRespostaLista(List<Cidade> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

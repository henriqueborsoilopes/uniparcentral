package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.ContaRequest;
import com.hblsistemas.uniparcentral.dtos.responses.ContaResponse;
import com.hblsistemas.uniparcentral.entidades.Conta;

@Component
public class ContaMapper {
	
	private final ModelMapper mapper;
	
	public ContaMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Conta paraEntidade(ContaRequest request) {
		return mapper.map(request, Conta.class);
	}
	
	public ContaResponse paraResposta(Conta entidade) {
		return mapper.map(entidade, ContaResponse.class);
	}
	
	public List<ContaResponse> paraRespostaLista(List<Conta> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

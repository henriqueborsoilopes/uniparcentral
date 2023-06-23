package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.EnderecoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.EnderecoResponse;
import com.hblsistemas.uniparcentral.entidades.Endereco;

@Component
public class EnderecoMapper {
	
	private final ModelMapper mapper;
	
	public EnderecoMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Endereco paraEntidade(EnderecoRequest request) {
		return mapper.map(request, Endereco.class);
	}
	
	public EnderecoResponse paraResposta(Endereco entidade) {
		return mapper.map(entidade, EnderecoResponse.class);
	}
	
	public List<EnderecoResponse> paraRespostaLista(List<Endereco> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

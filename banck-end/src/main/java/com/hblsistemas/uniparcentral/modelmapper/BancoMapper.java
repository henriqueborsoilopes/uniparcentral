package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.BancoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.BancoResponse;
import com.hblsistemas.uniparcentral.entidades.Banco;

@Component
public class BancoMapper {
	
	private final ModelMapper mapper;
	
	public BancoMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Banco paraEntidade(BancoRequest request) {
		return mapper.map(request, Banco.class);
	}
	
	public BancoResponse paraResposta(Banco entidade) {
		return mapper.map(entidade, BancoResponse.class);
	}
	
	public List<BancoResponse> paraRespostaLista(List<Banco> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

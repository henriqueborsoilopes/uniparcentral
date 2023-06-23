package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.TelefoneRequest;
import com.hblsistemas.uniparcentral.dtos.responses.TelefoneResponse;
import com.hblsistemas.uniparcentral.entidades.Telefone;

@Component
public class TelefoneMapper {
	
	private final ModelMapper mapper;
	
	public TelefoneMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Telefone paraEntidade(TelefoneRequest request) {
		return mapper.map(request, Telefone.class);
	}
	
	public TelefoneResponse paraResposta(Telefone entidade) {
		return mapper.map(entidade, TelefoneResponse.class);
	}
	
	public List<TelefoneResponse> paraRespostaLista(List<Telefone> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

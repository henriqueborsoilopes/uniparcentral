package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.hblsistemas.uniparcentral.dtos.requests.AgenciaRequest;
import com.hblsistemas.uniparcentral.entidades.Agencia;

public class AgenciaModel {
	
	private final ModelMapper model;
	
	public AgenciaModel(ModelMapper model) {
		this.model = model;
	}
	
	public Agencia paraEntidade(AgenciaRequest dto) {
		return model.map(dto, Agencia.class);
	}
	
	public AgenciaRequest paraDTO(Agencia entidade) {
		return model.map(entidade, AgenciaRequest.class);
	}
	
	public List<AgenciaRequest> paraDTOLista(List<Agencia> entidades) {
		return entidades.stream().map(this::paraDTO).collect(Collectors.toList());
	}
}

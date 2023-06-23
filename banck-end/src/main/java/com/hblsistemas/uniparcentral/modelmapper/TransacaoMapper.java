package com.hblsistemas.uniparcentral.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.dtos.requests.TransacaoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.TransacaoResponse;
import com.hblsistemas.uniparcentral.entidades.Transacao;

@Component
public class TransacaoMapper {
	
	private final ModelMapper mapper;
	
	public TransacaoMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Transacao paraEntidade(TransacaoRequest request) {
		return mapper.map(request, Transacao.class);
	}
	
	public TransacaoResponse paraResposta(Transacao entidade) {
		return mapper.map(entidade, TransacaoResponse.class);
	}
	
	public List<TransacaoResponse> paraRespostaLista(List<Transacao> entidades) {
		return entidades.stream().map(this::paraResposta).collect(Collectors.toList());
	}
}

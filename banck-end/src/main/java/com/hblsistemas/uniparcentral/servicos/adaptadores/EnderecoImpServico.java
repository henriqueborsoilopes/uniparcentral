package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.EnderecoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.EnderecoResponse;
import com.hblsistemas.uniparcentral.modelmapper.EnderecoMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.EnderecoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.EnderecoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.EnderecoValidacao;

@Service
public class EnderecoImpServico implements EnderecoPortaServico {
	
	private final EnderecoPortaRepositorio enderecoRepositorioPorta;
	private final EnderecoMapper mapper;
	
	public EnderecoImpServico(EnderecoPortaRepositorio enderecoRepositorioPorta, EnderecoMapper mapper) {
		this.enderecoRepositorioPorta = enderecoRepositorioPorta;
		this.mapper = mapper;
	}
	
	@Override
	public EnderecoResponse inserir(EnderecoRequest request) {
		EnderecoValidacao.validarTodosCampos(request);
		return mapper.paraResposta(enderecoRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<EnderecoResponse> acharTodos() {
		return mapper.paraRespostaLista(enderecoRepositorioPorta.acharTodos());
	}
	
	@Override
	public EnderecoResponse acharPorId(Long id) {
		return mapper.paraResposta(enderecoRepositorioPorta.acharPorId(id));
	}
	
	@Override
	public void atualizar(EnderecoRequest request, Long id) {
		EnderecoValidacao.validarTodosCampos(request);
		enderecoRepositorioPorta.atualizar(mapper.paraEntidade(request), id);
	}
	
	@Override
	public void deletar(Long id) {
		enderecoRepositorioPorta.deletar(id);
	}
}

package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.BancoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.BancoResponse;
import com.hblsistemas.uniparcentral.modelmapper.BancoMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.BancoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.BancoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.BancoValidacao;

@Service
public class BancoImpServico implements BancoPortaServico {
	
	private final BancoPortaRepositorio bancoRepositorioPorta;
	private final BancoMapper mapper;
	
	public BancoImpServico(BancoPortaRepositorio bancoRepositorioPorta, BancoMapper mapper) {
		this.bancoRepositorioPorta = bancoRepositorioPorta;
		this.mapper = mapper;
	}
	
	@Override
	public BancoResponse inserir(BancoRequest request) {
		BancoValidacao.validarTodosCampos(request);
		return mapper.paraResposta(bancoRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<BancoResponse> acharTodos() {
		return mapper.paraRespostaLista(bancoRepositorioPorta.acharTodos());
	}
	
	@Override
	public BancoResponse acharPorId(Long id) {
		return mapper.paraResposta(bancoRepositorioPorta.acharPorId(id));
	}
	
	@Override
	public void atualizar(BancoRequest request, Long id) {
		BancoValidacao.validarTodosCampos(request);
		bancoRepositorioPorta.atualizar(mapper.paraEntidade(request), id);
	}
	
	@Override
	public void deletar(Long id) {
		bancoRepositorioPorta.deletar(id);
	}
}

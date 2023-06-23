package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.TelefoneRequest;
import com.hblsistemas.uniparcentral.dtos.responses.TelefoneResponse;
import com.hblsistemas.uniparcentral.modelmapper.TelefoneMapper;
import com.hblsistemas.uniparcentral.repositorios.portas.TelefonePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.TelefonePortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.TelefoneValidacao;

@Service
public class TelefoneImpServico implements TelefonePortaServico {
	
	private final TelefonePortaRepositorio telefoneRepositorioPorta;
	private final TelefoneMapper mapper;
	
	public TelefoneImpServico(TelefonePortaRepositorio telefoneRepositorioPorta, TelefoneMapper mapper) {
		this.telefoneRepositorioPorta = telefoneRepositorioPorta;
		this.mapper = mapper;
	}
	
	@Override
	public TelefoneResponse inserir(TelefoneRequest request) {
		TelefoneValidacao.validarTodosCampos(request);
		return mapper.paraResposta(telefoneRepositorioPorta.inserir(mapper.paraEntidade(request)));
	}
	
	@Override
	public List<TelefoneResponse> acharTodos() {
		return mapper.paraRespostaLista(telefoneRepositorioPorta.acharTodos());
	}
	
	@Override
	public TelefoneResponse acharPorId(Long id) {
		return mapper.paraResposta(telefoneRepositorioPorta.acharPorId(id));
	}
	
	@Override
	public void atualizar(TelefoneRequest request, Long id) {
		TelefoneValidacao.validarTodosCampos(request);
		telefoneRepositorioPorta.atualizar(mapper.paraEntidade(request), id);
	}
	
	@Override
	public void deletar(Long id) {
		telefoneRepositorioPorta.deletar(id);
	}
}

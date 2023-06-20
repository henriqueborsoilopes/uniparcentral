package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Estado;
import com.hblsistemas.uniparcentral.repositorios.portas.EstadoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.EstadoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.EstadoValidacao;

@Service
public class EstadoImpServico implements EstadoPortaServico {

	private final EstadoPortaRepositorio estadoRepositorioPorta;
	private final PaisImpServico paisServico;
	
	public EstadoImpServico(EstadoPortaRepositorio estadoRepositorioPorta, PaisImpServico paisServico) {
		this.estadoRepositorioPorta = estadoRepositorioPorta;
		this.paisServico = paisServico;
	}
	
	@Override
	public Estado inserir(Estado estado) {
		EstadoValidacao.validarTodosCamposParaInserir(estado);
		return estadoRepositorioPorta.inserir(estado);
	}
	
	@Override
	public List<Estado> acharTodos() {
		return estadoRepositorioPorta.acharTodos();
	}
	
	@Override
	public Estado acharPorId(Long id) {
		Estado estado = estadoRepositorioPorta.acharPorId(id);
		estado.setPais(paisServico.acharPorId(estado.getId()));
		return estado;
	}
	
	@Override
	public void atualizar(Estado estado, Long id) {
		EstadoValidacao.validarTodosCamposParaUpdate(estado);
		estadoRepositorioPorta.atualizar(estado, id);
	}
	
	@Override
	public void deletar(Long id) {
		estadoRepositorioPorta.acharPorId(id);
		estadoRepositorioPorta.deletar(id);
	}
}

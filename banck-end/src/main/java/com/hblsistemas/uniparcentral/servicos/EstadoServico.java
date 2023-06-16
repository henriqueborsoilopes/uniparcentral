package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Estado;
import com.hblsistemas.uniparcentral.repositorios.portas.EstadoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.EstadoValidacao;

@Service
public class EstadoServico {

	private final EstadoPortaRepositorio estadoRepositorioPorta;
	private final PaisServico paisServico;
	
	public EstadoServico(EstadoPortaRepositorio estadoRepositorioPorta, PaisServico paisServico) {
		this.estadoRepositorioPorta = estadoRepositorioPorta;
		this.paisServico = paisServico;
	}
	
	public void inserir(Estado estado) {
		EstadoValidacao.validarTodosCamposParaInserir(estado);
		estadoRepositorioPorta.inserir(estado);
	}
	
	public List<Estado> acharTodos() {
		return estadoRepositorioPorta.acharTodos();
	}
	
	public Estado acharPorId(Long id) {
		Estado estado = estadoRepositorioPorta.acharPorId(id);
		estado.setPais(paisServico.acharPorId(estado.getId()));
		return estado;
	}
	
	public void atualizar(Long id, Estado estado) {
		EstadoValidacao.validarTodosCamposParaUpdate(estado);
		estadoRepositorioPorta.atualizar(estado, id);
	}
	
	public void deletar(Long id) {
		estadoRepositorioPorta.acharPorId(id);
		estadoRepositorioPorta.deletar(id);
	}
}

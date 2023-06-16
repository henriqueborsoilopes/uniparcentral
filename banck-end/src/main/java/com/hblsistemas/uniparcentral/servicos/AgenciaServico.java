package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.repositorios.portas.AgenciaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.AgenciaValidacao;

@Service
public class AgenciaServico {
	
	private final AgenciaPortaRepositorio agenciaRepositorioPorta;
	
	public AgenciaServico(AgenciaPortaRepositorio agenciaRepositorioPorta) {
		this.agenciaRepositorioPorta = agenciaRepositorioPorta;
	}
	
	public void inserir(Agencia agencia) {
		AgenciaValidacao.validarTodosCampos(agencia);
		agenciaRepositorioPorta.inserir(agencia);
	}
	
	public List<Agencia> acharTodos() {
		return agenciaRepositorioPorta.acharTodos();
	}
	
	public Agencia acharPorId(Long id) {
		return agenciaRepositorioPorta.acharPorId(id);
	}
	
	public void atualizar(Long id, Agencia agencia) {
		AgenciaValidacao.validarTodosCampos(agencia);
		agenciaRepositorioPorta.atualizar(agencia, id);
	}
	
	public void deletar(Long id) {
		agenciaRepositorioPorta.deletar(id);
	}
}

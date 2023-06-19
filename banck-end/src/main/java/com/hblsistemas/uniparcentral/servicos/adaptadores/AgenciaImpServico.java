package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.repositorios.portas.AgenciaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.AgenciaValidacao;

@Service
public class AgenciaImpServico {
	
	private final AgenciaPortaRepositorio agenciaRepositorioPorta;
	private final BancoImpServico bancoServico;
	
	public AgenciaImpServico(AgenciaPortaRepositorio agenciaRepositorioPorta, BancoImpServico bancoServico) {
		this.agenciaRepositorioPorta = agenciaRepositorioPorta;
		this.bancoServico = bancoServico;
	}
	
	public void inserir(Agencia agencia) {
		AgenciaValidacao.validarTodosCamposParaInserir(agencia);
		agenciaRepositorioPorta.inserir(agencia);
	}
	
	public List<Agencia> acharTodos() {
		return agenciaRepositorioPorta.acharTodos();
	}
	
	public Agencia acharPorId(Long id) {
		Agencia agencia = agenciaRepositorioPorta.acharPorId(id);
		agencia.setBanco(bancoServico.acharPorId(agencia.getBanco().getId()));
		return agencia;
	}
	
	public void atualizar(Long id, Agencia agencia) {
		AgenciaValidacao.validarTodosCamposParaUpdate(agencia);
		agenciaRepositorioPorta.atualizar(agencia, id);
	}
	
	public void deletar(Long id) {
		agenciaRepositorioPorta.acharPorId(id);
		agenciaRepositorioPorta.deletar(id);
	}
}

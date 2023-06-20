package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.repositorios.portas.AgenciaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.AgenciaPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.AgenciaValidacao;

@Service
public class AgenciaImpServico implements AgenciaPortaServico {
	
	private final AgenciaPortaRepositorio agenciaRepositorioPorta;
	private final BancoImpServico bancoServico;
	
	public AgenciaImpServico(AgenciaPortaRepositorio agenciaRepositorioPorta, BancoImpServico bancoServico) {
		this.agenciaRepositorioPorta = agenciaRepositorioPorta;
		this.bancoServico = bancoServico;
	}
	
	@Override
	public Agencia inserir(Agencia agencia) {
		AgenciaValidacao.validarTodosCamposParaInserir(agencia);
		return agenciaRepositorioPorta.inserir(agencia);
	}
	
	@Override
	public List<Agencia> acharTodos() {
		return agenciaRepositorioPorta.acharTodos();
	}
	
	@Override
	public Agencia acharPorId(Long id) {
		Agencia agencia = agenciaRepositorioPorta.acharPorId(id);
		agencia.setBanco(bancoServico.acharPorId(agencia.getBanco().getId()));
		return agencia;
	}
	
	@Override
	public void atualizar(Agencia agencia, Long id) {
		AgenciaValidacao.validarTodosCamposParaUpdate(agencia);
		agenciaRepositorioPorta.atualizar(agencia, id);
	}
	
	@Override
	public void deletar(Long id) {
		agenciaRepositorioPorta.acharPorId(id);
		agenciaRepositorioPorta.deletar(id);
	}
}

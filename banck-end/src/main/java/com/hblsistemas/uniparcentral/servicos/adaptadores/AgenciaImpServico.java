package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.dtos.requests.AgenciaRequest;
import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.modelmapper.AgenciaModel;
import com.hblsistemas.uniparcentral.repositorios.portas.AgenciaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.AgenciaPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.AgenciaValidacao;

@Service
public class AgenciaImpServico implements AgenciaPortaServico {
	
	private final AgenciaPortaRepositorio agenciaRepositorioPorta;
	private final BancoImpServico bancoServico;
	private final AgenciaModel agenciaModel;
	
	public AgenciaImpServico(AgenciaPortaRepositorio agenciaRepositorioPorta, BancoImpServico bancoServico, AgenciaModel agenciaModel) {
		this.agenciaRepositorioPorta = agenciaRepositorioPorta;
		this.bancoServico = bancoServico;
		this.agenciaModel = agenciaModel;
	}
	
	@Override
	public AgenciaRequest inserir(AgenciaRequest agenciaDTO) {
		AgenciaValidacao.validarTodosCamposParaInserir(agenciaDTO);
		Agencia agencia = agenciaModel.paraEntidade(agenciaDTO);
		return agenciaModel.paraDTO(agenciaRepositorioPorta.inserir(agencia));
	}
	
	@Override
	public List<AgenciaRequest> acharTodos() {
		return agenciaModel.paraDTOLista(agenciaRepositorioPorta.acharTodos());
	}
	
	@Override
	public AgenciaRequest acharPorId(Long id) {
		Agencia agencia = agenciaRepositorioPorta.acharPorId(id);
		agencia.setBanco(bancoServico.acharPorId(agencia.getBanco().getId()));
		return agenciaModel.paraDTO(agencia);
	}
	
	@Override
	public void atualizar(AgenciaRequest agenciaDTO, Long id) {
		AgenciaValidacao.validarTodosCamposParaUpdate(agenciaDTO);
		agenciaRepositorioPorta.atualizar(agenciaModel.paraEntidade(agenciaDTO), id);
	}
	
	@Override
	public void deletar(Long id) {
		agenciaRepositorioPorta.acharPorId(id);
		agenciaRepositorioPorta.deletar(id);
	}
}

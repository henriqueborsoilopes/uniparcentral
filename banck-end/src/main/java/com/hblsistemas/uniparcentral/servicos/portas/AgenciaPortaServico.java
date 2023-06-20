package com.hblsistemas.uniparcentral.servicos.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.dtos.AgenciaDTO;

public interface AgenciaPortaServico {
	
	public AgenciaDTO inserir(AgenciaDTO agencia);
	public List<AgenciaDTO> acharTodos();
	public AgenciaDTO acharPorId(Long id);
	public void atualizar(AgenciaDTO agenciaDTO, Long id);
	public void deletar(Long id);
}

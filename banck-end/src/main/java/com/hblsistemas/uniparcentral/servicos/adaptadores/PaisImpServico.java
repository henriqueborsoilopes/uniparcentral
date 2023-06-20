package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Pais;
import com.hblsistemas.uniparcentral.repositorios.portas.PaisPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.PaisPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.PaisValidacao;

@Service
public class PaisImpServico implements PaisPortaServico {
	
	private final PaisPortaRepositorio paisRepositorioPorta;
	
	public PaisImpServico(PaisPortaRepositorio paisRepositorioPorta) {
		this.paisRepositorioPorta = paisRepositorioPorta;
	}
	
	@Override
	public Pais inserir(Pais pais) {
		PaisValidacao.validarTodosCampos(pais);
		return paisRepositorioPorta.inserir(pais);
	}
	
	@Override
	public List<Pais> acharTodos() {
		return paisRepositorioPorta.acharTodos();
	}
	
	@Override
	public Pais acharPorId(Long id) {
		return paisRepositorioPorta.acharPorId(id);
	}
	
	@Override
	public void atualizar(Pais pais, Long id) {
		PaisValidacao.validarTodosCampos(pais);
		paisRepositorioPorta.atualizar(pais, id);
	}
	
	@Override
	public void deletar(Long id) {
		paisRepositorioPorta.acharPorId(id);
		paisRepositorioPorta.deletar(id);
	}
}

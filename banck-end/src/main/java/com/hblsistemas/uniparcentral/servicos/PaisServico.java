package com.hblsistemas.uniparcentral.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Pais;
import com.hblsistemas.uniparcentral.repositorios.portas.PaisPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.PaisValidacao;

@Service
public class PaisServico {
	
	private final PaisPortaRepositorio paisRepositorioPorta;
	
	public PaisServico(PaisPortaRepositorio paisRepositorioPorta) {
		this.paisRepositorioPorta = paisRepositorioPorta;
	}
	
	public void inserir(Pais pais) {
		PaisValidacao.validarTodosCampos(pais);
		paisRepositorioPorta.inserir(pais);
	}
	
	public List<Pais> acharTodos() {
		return paisRepositorioPorta.acharTodos();
	}
	
	public Pais acharPorId(Long id) {
		return paisRepositorioPorta.acharPorId(id);
	}
	
	public void atualizar(Long id, Pais pais) {
		PaisValidacao.validarTodosCampos(pais);
		paisRepositorioPorta.atualizar(pais, id);
	}
	
	public void deletar(Long id) {
		paisRepositorioPorta.acharPorId(id);
		paisRepositorioPorta.deletar(id);
	}
}

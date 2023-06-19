package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Telefone;
import com.hblsistemas.uniparcentral.repositorios.portas.TelefonePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.TelefoneValidacao;

@Service
public class TelefoneImpServico {
	
	private final TelefonePortaRepositorio telefoneRepositorioPorta;
	
	public TelefoneImpServico(TelefonePortaRepositorio telefoneRepositorioPorta) {
		this.telefoneRepositorioPorta = telefoneRepositorioPorta;
	}
	
	public void inserir(Telefone telefone) {
		TelefoneValidacao.validarTodosCampos(telefone);
		telefoneRepositorioPorta.inserir(telefone);
	}
	
	public List<Telefone> acharTodos() {
		return telefoneRepositorioPorta.acharTodos();
	}
	
	public Telefone acharPorId(Long id) {
		return telefoneRepositorioPorta.acharPorId(id);
	}
	
	public void atualizar(Long id, Telefone telefone) {
		TelefoneValidacao.validarTodosCampos(telefone);
		telefoneRepositorioPorta.atualizar(telefone, id);
	}
	
	public void deletar(Long id) {
		telefoneRepositorioPorta.deletar(id);
	}
}

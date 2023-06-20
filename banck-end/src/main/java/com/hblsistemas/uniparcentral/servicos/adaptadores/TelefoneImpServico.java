package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Telefone;
import com.hblsistemas.uniparcentral.repositorios.portas.TelefonePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.TelefonePortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.TelefoneValidacao;

@Service
public class TelefoneImpServico implements TelefonePortaServico {
	
	private final TelefonePortaRepositorio telefoneRepositorioPorta;
	
	public TelefoneImpServico(TelefonePortaRepositorio telefoneRepositorioPorta) {
		this.telefoneRepositorioPorta = telefoneRepositorioPorta;
	}
	
	@Override
	public Telefone inserir(Telefone telefone) {
		TelefoneValidacao.validarTodosCampos(telefone);
		return telefoneRepositorioPorta.inserir(telefone);
	}
	
	@Override
	public List<Telefone> acharTodos() {
		return telefoneRepositorioPorta.acharTodos();
	}
	
	@Override
	public Telefone acharPorId(Long id) {
		return telefoneRepositorioPorta.acharPorId(id);
	}
	
	@Override
	public void atualizar(Telefone telefone, Long id) {
		TelefoneValidacao.validarTodosCampos(telefone);
		telefoneRepositorioPorta.atualizar(telefone, id);
	}
	
	@Override
	public void deletar(Long id) {
		telefoneRepositorioPorta.deletar(id);
	}
}

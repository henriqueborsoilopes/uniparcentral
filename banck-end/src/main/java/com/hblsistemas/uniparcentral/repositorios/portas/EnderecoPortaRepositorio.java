package com.hblsistemas.uniparcentral.repositorios.portas;

import java.util.List;

import com.hblsistemas.uniparcentral.entidades.Endereco;

public interface EnderecoPortaRepositorio {
	
	public Endereco inserir(Endereco endereco);
	public List<Endereco> acharTodos();
	public Endereco acharPorId(Long id);
	public void atualizar(Endereco endereco, Long id);
	public void deletar(Long id);
}

package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Endereco;
import com.hblsistemas.uniparcentral.repositorios.portas.EnderecoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.validacoes.EnderecoValidacao;

@Service
public class EnderecoImpServico {
	
	private final EnderecoPortaRepositorio enderecoRepositorioPorta;
	
	public EnderecoImpServico(EnderecoPortaRepositorio enderecoRepositorioPorta) {
		this.enderecoRepositorioPorta = enderecoRepositorioPorta;
	}
	
	public void inserir(Endereco endereco) {
		EnderecoValidacao.validarTodosCampos(endereco);
		enderecoRepositorioPorta.inserir(endereco);
	}
	
	public List<Endereco> acharTodos() {
		return enderecoRepositorioPorta.acharTodos();
	}
	
	public Endereco acharPorId(Long id) {
		return enderecoRepositorioPorta.acharPorId(id);
	}
	
	public void atualizar(Long id, Endereco endereco) {
		EnderecoValidacao.validarTodosCampos(endereco);
		enderecoRepositorioPorta.atualizar(endereco, id);
	}
	
	public void deletar(Long id) {
		enderecoRepositorioPorta.deletar(id);
	}
}

package com.hblsistemas.uniparcentral.servicos.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Endereco;
import com.hblsistemas.uniparcentral.repositorios.portas.EnderecoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.portas.EnderecoPortaServico;
import com.hblsistemas.uniparcentral.servicos.validacoes.EnderecoValidacao;

@Service
public class EnderecoImpServico implements EnderecoPortaServico {
	
	private final EnderecoPortaRepositorio enderecoRepositorioPorta;
	
	public EnderecoImpServico(EnderecoPortaRepositorio enderecoRepositorioPorta) {
		this.enderecoRepositorioPorta = enderecoRepositorioPorta;
	}
	
	@Override
	public Endereco inserir(Endereco endereco) {
		EnderecoValidacao.validarTodosCampos(endereco);
		return enderecoRepositorioPorta.inserir(endereco);
	}
	
	@Override
	public List<Endereco> acharTodos() {
		return enderecoRepositorioPorta.acharTodos();
	}
	
	@Override
	public Endereco acharPorId(Long id) {
		return enderecoRepositorioPorta.acharPorId(id);
	}
	
	@Override
	public void atualizar(Endereco endereco, Long id) {
		EnderecoValidacao.validarTodosCampos(endereco);
		enderecoRepositorioPorta.atualizar(endereco, id);
	}
	
	@Override
	public void deletar(Long id) {
		enderecoRepositorioPorta.deletar(id);
	}
}

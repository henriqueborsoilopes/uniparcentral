package com.hblsistemas.uniparcentral.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.servicos.PessoaServico;

@RestController
@RequestMapping("/pessoas")
public class PessoaControlador {
	
	private PessoaServico pessoaServico;
	
	public PessoaControlador(PessoaServico pessoaServico) {
		this.pessoaServico = pessoaServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Pessoa pessoa) {
		pessoaServico.inserir(pessoa);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> acharTodos() {
		List<Pessoa> pessoas = pessoaServico.acharTodos();
		return ResponseEntity.ok().body(pessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> acharPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaServico.acharPorId(id);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		pessoaServico.atualizar(id, pessoa);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		pessoaServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

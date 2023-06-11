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

import com.hblsistemas.uniparcentral.entidades.Endereco;
import com.hblsistemas.uniparcentral.servicos.EnderecoServico;

@RestController
@RequestMapping("/enderecos")
public class EnderecoControlador {
	
	private EnderecoServico enderecoServico;
	
	public EnderecoControlador(EnderecoServico enderecoServico) {
		this.enderecoServico = enderecoServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Endereco endereco) {
		enderecoServico.inserir(endereco);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> acharTodos() {
		List<Endereco> enderecos = enderecoServico.acharTodos();
		return ResponseEntity.ok().body(enderecos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> acharPorId(@PathVariable Long id) {
		Endereco endereco = enderecoServico.acharPorId(id);
		return ResponseEntity.ok().body(endereco);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Endereco endereco) {
		enderecoServico.atualizar(id, endereco);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		enderecoServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

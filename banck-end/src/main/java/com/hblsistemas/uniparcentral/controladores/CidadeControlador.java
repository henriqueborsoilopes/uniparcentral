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

import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.servicos.adaptadores.CidadeImpServico;

@RestController
@RequestMapping("/cidades")
public class CidadeControlador {
	
	private CidadeImpServico cidadeServico;
	
	public CidadeControlador(CidadeImpServico cidadeServico) {
		this.cidadeServico = cidadeServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Cidade cidade) {
		cidadeServico.inserir(cidade);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Cidade>> acharTodos() {
		List<Cidade> cidades = cidadeServico.acharTodos();
		return ResponseEntity.ok().body(cidades);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> acharPorId(@PathVariable Long id) {
		Cidade cidade = cidadeServico.acharPorId(id);
		return ResponseEntity.ok().body(cidade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Cidade cidade) {
		cidadeServico.atualizar(id, cidade);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		cidadeServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

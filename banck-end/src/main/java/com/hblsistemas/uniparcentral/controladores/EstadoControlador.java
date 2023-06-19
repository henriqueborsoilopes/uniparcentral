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

import com.hblsistemas.uniparcentral.entidades.Estado;
import com.hblsistemas.uniparcentral.servicos.adaptadores.EstadoImpServico;

@RestController
@RequestMapping("/estados")
public class EstadoControlador {
	
	private EstadoImpServico estadoServico;
	
	public EstadoControlador(EstadoImpServico estadoServico) {
		this.estadoServico = estadoServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Estado estado) {
		estadoServico.inserir(estado);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Estado>> acharTodos() {
		List<Estado> estados = estadoServico.acharTodos();
		return ResponseEntity.ok().body(estados);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> acharPorId(@PathVariable Long id) {
		Estado estado = estadoServico.acharPorId(id);
		return ResponseEntity.ok().body(estado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Estado estado) {
		estadoServico.atualizar(id, estado);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		estadoServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

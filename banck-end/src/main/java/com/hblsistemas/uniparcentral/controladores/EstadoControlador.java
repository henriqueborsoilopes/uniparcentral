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

import com.hblsistemas.uniparcentral.dtos.requests.EstadoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.EstadoResponse;
import com.hblsistemas.uniparcentral.servicos.portas.EstadoPortaServico;

@RestController
@RequestMapping("/estados")
public class EstadoControlador {
	
	private EstadoPortaServico estadoServico;
	
	public EstadoControlador(EstadoPortaServico estadoServico) {
		this.estadoServico = estadoServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody EstadoRequest estado) {
		estadoServico.inserir(estado);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<EstadoResponse>> acharTodos() {
		List<EstadoResponse> estados = estadoServico.acharTodos();
		return ResponseEntity.ok().body(estados);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstadoResponse> acharPorId(@PathVariable Long id) {
		EstadoResponse estado = estadoServico.acharPorId(id);
		return ResponseEntity.ok().body(estado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody EstadoRequest estado) {
		estadoServico.atualizar(estado, id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		estadoServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

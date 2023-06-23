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

import com.hblsistemas.uniparcentral.dtos.requests.PaisRequest;
import com.hblsistemas.uniparcentral.dtos.responses.PaisResponse;
import com.hblsistemas.uniparcentral.servicos.portas.PaisPortaServico;

@RestController
@RequestMapping("/paises")
public class PaisControlador {
	
	private PaisPortaServico paisServico;
	
	public PaisControlador(PaisPortaServico paisServico) {
		this.paisServico = paisServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody PaisRequest pais) {
		paisServico.inserir(pais);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<PaisResponse>> acharTodos() {
		List<PaisResponse> paises = paisServico.acharTodos();
		return ResponseEntity.ok().body(paises);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaisResponse> acharPorId(@PathVariable Long id) {
		PaisResponse pais = paisServico.acharPorId(id);
		return ResponseEntity.ok().body(pais);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody PaisRequest pais) {
		paisServico.atualizar(pais, id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		paisServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

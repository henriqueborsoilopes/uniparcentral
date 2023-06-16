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

import com.hblsistemas.uniparcentral.entidades.Pais;
import com.hblsistemas.uniparcentral.servicos.PaisServico;

@RestController
@RequestMapping("/paises")
public class PaisControlador {
	
	private PaisServico paisServico;
	
	public PaisControlador(PaisServico paisServico) {
		this.paisServico = paisServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Pais pais) {
		paisServico.inserir(pais);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Pais>> acharTodos() {
		List<Pais> paises = paisServico.acharTodos();
		return ResponseEntity.ok().body(paises);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pais> acharPorId(@PathVariable Long id) {
		Pais pais = paisServico.acharPorId(id);
		return ResponseEntity.ok().body(pais);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Pais pais) {
		paisServico.atualizar(id, pais);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		paisServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

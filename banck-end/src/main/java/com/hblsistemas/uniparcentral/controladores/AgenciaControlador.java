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

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.servicos.adaptadores.AgenciaImpServico;

@RestController
@RequestMapping("/agencias")
public class AgenciaControlador {
	
	private AgenciaImpServico agenciaServico;
	
	public AgenciaControlador(AgenciaImpServico agenciaServico) {
		this.agenciaServico = agenciaServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Agencia agencia) {
		agenciaServico.inserir(agencia);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Agencia>> acharTodos() {
		List<Agencia> agencias = agenciaServico.acharTodos();
		return ResponseEntity.ok().body(agencias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Agencia> acharPorId(@PathVariable Long id) {
		Agencia agencia = agenciaServico.acharPorId(id);
		return ResponseEntity.ok().body(agencia);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Agencia agencia) {
		agenciaServico.atualizar(agencia, id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		agenciaServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

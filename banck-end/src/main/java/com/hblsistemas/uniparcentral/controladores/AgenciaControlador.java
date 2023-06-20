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

import com.hblsistemas.uniparcentral.dtos.AgenciaDTO;
import com.hblsistemas.uniparcentral.servicos.portas.AgenciaPortaServico;

@RestController
@RequestMapping("/agencias")
public class AgenciaControlador {
	
	private AgenciaPortaServico agenciaServico;
	
	public AgenciaControlador(AgenciaPortaServico agenciaServico) {
		this.agenciaServico = agenciaServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody AgenciaDTO agenciaDTO) {
		agenciaServico.inserir(agenciaDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<AgenciaDTO>> acharTodos() {
		List<AgenciaDTO> agenciasDTO = agenciaServico.acharTodos();
		return ResponseEntity.ok().body(agenciasDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AgenciaDTO> acharPorId(@PathVariable Long id) {
		AgenciaDTO agenciaDTO = agenciaServico.acharPorId(id);
		return ResponseEntity.ok().body(agenciaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody AgenciaDTO agenciaDTO) {
		agenciaServico.atualizar(agenciaDTO, id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		agenciaServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

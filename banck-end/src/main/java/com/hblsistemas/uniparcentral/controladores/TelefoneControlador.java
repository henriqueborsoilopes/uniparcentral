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

import com.hblsistemas.uniparcentral.entidades.Telefone;
import com.hblsistemas.uniparcentral.servicos.adaptadores.TelefoneImpServico;

@RestController
@RequestMapping("/telefones")
public class TelefoneControlador {
	
	private TelefoneImpServico telefoneServico;
	
	public TelefoneControlador(TelefoneImpServico telefoneServico) {
		this.telefoneServico = telefoneServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Telefone telefone) {
		telefoneServico.inserir(telefone);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Telefone>> acharTodos() {
		List<Telefone> telefones = telefoneServico.acharTodos();
		return ResponseEntity.ok().body(telefones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Telefone> acharPorId(@PathVariable Long id) {
		Telefone telefone = telefoneServico.acharPorId(id);
		return ResponseEntity.ok().body(telefone);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Telefone telefone) {
		telefoneServico.atualizar(id, telefone);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		telefoneServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

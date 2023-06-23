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

import com.hblsistemas.uniparcentral.dtos.requests.TelefoneRequest;
import com.hblsistemas.uniparcentral.dtos.responses.TelefoneResponse;
import com.hblsistemas.uniparcentral.servicos.portas.TelefonePortaServico;

@RestController
@RequestMapping("/telefones")
public class TelefoneControlador {
	
	private TelefonePortaServico telefoneServico;
	
	public TelefoneControlador(TelefonePortaServico telefoneServico) {
		this.telefoneServico = telefoneServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody TelefoneRequest request) {
		telefoneServico.inserir(request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<TelefoneResponse>> acharTodos() {
		List<TelefoneResponse> telefones = telefoneServico.acharTodos();
		return ResponseEntity.ok().body(telefones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TelefoneResponse> acharPorId(@PathVariable Long id) {
		TelefoneResponse telefone = telefoneServico.acharPorId(id);
		return ResponseEntity.ok().body(telefone);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody TelefoneRequest telefone) {
		telefoneServico.atualizar(telefone, id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		telefoneServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

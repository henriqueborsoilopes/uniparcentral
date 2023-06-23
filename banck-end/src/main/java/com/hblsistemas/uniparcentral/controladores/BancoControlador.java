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

import com.hblsistemas.uniparcentral.dtos.requests.BancoRequest;
import com.hblsistemas.uniparcentral.dtos.responses.BancoResponse;
import com.hblsistemas.uniparcentral.servicos.portas.BancoPortaServico;

@RestController
@RequestMapping("/bancos")
public class BancoControlador {
	
	private BancoPortaServico bancoServico;
	
	public BancoControlador(BancoPortaServico bancoServico) {
		this.bancoServico = bancoServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody BancoRequest banco) {
		bancoServico.inserir(banco);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<BancoResponse>> acharTodos() {
		List<BancoResponse> bancos = bancoServico.acharTodos();
		return ResponseEntity.ok().body(bancos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BancoResponse> acharPorId(@PathVariable Long id) {
		BancoResponse banco = bancoServico.acharPorId(id);
		return ResponseEntity.ok().body(banco);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody BancoRequest banco) {
		bancoServico.atualizar(banco, id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		bancoServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

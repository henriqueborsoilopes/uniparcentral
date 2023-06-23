package com.hblsistemas.uniparcentral.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hblsistemas.uniparcentral.dtos.requests.ContaRequest;
import com.hblsistemas.uniparcentral.dtos.responses.ContaResponse;
import com.hblsistemas.uniparcentral.servicos.portas.ContaPortaServico;

@RestController
@RequestMapping("/contas")
public class ContaControlador {
	
	private ContaPortaServico contaServico;
	
	public ContaControlador(ContaPortaServico contaServico) {
		this.contaServico = contaServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody ContaRequest conta) {
		contaServico.inserir(conta);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ContaResponse>> acharTodos() {
		List<ContaResponse> contas = contaServico.acharTodos();
		return ResponseEntity.ok().body(contas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContaResponse> acharPorId(@PathVariable Long id) {
		ContaResponse conta = contaServico.acharPorId(id);
		return ResponseEntity.ok().body(conta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		contaServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

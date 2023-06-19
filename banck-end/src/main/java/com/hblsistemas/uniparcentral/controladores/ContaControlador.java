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

import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.servicos.adaptadores.ContaImpServico;

@RestController
@RequestMapping("/contas")
public class ContaControlador {
	
	private ContaImpServico contaServico;
	
	public ContaControlador(ContaImpServico contaServico) {
		this.contaServico = contaServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Conta conta) {
		contaServico.inserir(conta);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Conta>> acharTodos() {
		List<Conta> contas = contaServico.acharTodos();
		return ResponseEntity.ok().body(contas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> acharPorId(@PathVariable Long id) {
		Conta conta = contaServico.acharPorId(id);
		return ResponseEntity.ok().body(conta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		contaServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}

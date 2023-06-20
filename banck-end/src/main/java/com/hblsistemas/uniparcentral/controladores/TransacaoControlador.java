package com.hblsistemas.uniparcentral.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hblsistemas.uniparcentral.entidades.Transacao;
import com.hblsistemas.uniparcentral.servicos.portas.TransacaoPortaServico;

@RestController
@RequestMapping("/transacoes")
public class TransacaoControlador {
	
	private TransacaoPortaServico transacaoServico;
	
	public TransacaoControlador(TransacaoPortaServico transacaoServico) {
		this.transacaoServico = transacaoServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Transacao transacao) {
		transacaoServico.inserir(transacao);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Transacao>> acharTodos(@PathVariable Long conta_id) {
		List<Transacao> transacoes = transacaoServico.acharTodos(conta_id);
		return ResponseEntity.ok().body(transacoes);
	}
}

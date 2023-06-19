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
import com.hblsistemas.uniparcentral.servicos.adaptadores.TransacaoImpServico;

@RestController
@RequestMapping("/transacoes")
public class TransacaoControlador {
	
	private TransacaoImpServico transacaoServico;
	
	public TransacaoControlador(TransacaoImpServico transacaoServico) {
		this.transacaoServico = transacaoServico;
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Transacao transacao) {
		transacaoServico.inserir(transacao);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Transacao>> acharTodos() {
		List<Transacao> transacoes = transacaoServico.acharTodos();
		return ResponseEntity.ok().body(transacoes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transacao> acharPorId(@PathVariable Long id) {
		Transacao transacao = transacaoServico.acharPorId(id);
		return ResponseEntity.ok().body(transacao);
	}
}

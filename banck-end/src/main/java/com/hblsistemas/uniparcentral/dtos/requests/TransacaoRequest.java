package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;
import java.time.Instant;

public class TransacaoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String registroAluno;
	private Instant dataHora;
	private Double valor;
	private Integer tipoTransacao;
	private Long contaOrigem_id;
	private Long contaDestino_id;
	
	public TransacaoRequest() { }

	public TransacaoRequest(Long id, String registroAluno, Instant dataHora, Double valor, Integer tipoTransacao,
			Long contaOrigem_id, Long contaDestino_id) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.dataHora = dataHora;
		this.valor = valor;
		this.tipoTransacao = tipoTransacao;
		this.contaOrigem_id = contaOrigem_id;
		this.contaDestino_id = contaDestino_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(Integer tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Long getContaOrigem_id() {
		return contaOrigem_id;
	}

	public void setContaOrigem_id(Long contaOrigem_id) {
		this.contaOrigem_id = contaOrigem_id;
	}

	public Long getContaDestino_id() {
		return contaDestino_id;
	}

	public void setContaDestino_id(Long contaDestino_id) {
		this.contaDestino_id = contaDestino_id;
	}
}

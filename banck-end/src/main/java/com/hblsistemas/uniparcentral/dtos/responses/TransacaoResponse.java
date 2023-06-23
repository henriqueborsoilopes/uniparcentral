package com.hblsistemas.uniparcentral.dtos.responses;

import java.io.Serializable;
import java.time.Instant;

public class TransacaoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant dataHora;
	private Double valor;
	private Integer tipoTransacao;
	
	public TransacaoResponse() { }

	public TransacaoResponse(Long id, Instant dataHora, Double valor, Integer tipoTransacao) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.valor = valor;
		this.tipoTransacao = tipoTransacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}

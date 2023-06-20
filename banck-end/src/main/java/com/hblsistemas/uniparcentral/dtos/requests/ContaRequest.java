package com.hblsistemas.uniparcentral.dtos.requests;

import java.io.Serializable;

public class ContaRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String registroAluno;
	private String numero;
	private String digito;
	private Double saldo;
	private Integer tipoConta;
	private Long agencia_id;
	private Long titular_id;
	
	public ContaRequest() { }

	public ContaRequest(Long id, String registroAluno, String numero, String digito, Double saldo, Integer tipoConta,
			Long agencia_id, Long titular_id) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.numero = numero;
		this.digito = digito;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.agencia_id = agencia_id;
		this.titular_id = titular_id;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(Integer tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Long getAgencia_id() {
		return agencia_id;
	}

	public void setAgencia_id(Long agencia_id) {
		this.agencia_id = agencia_id;
	}

	public Long getTitular_id() {
		return titular_id;
	}

	public void setTitular_id(Long titular_id) {
		this.titular_id = titular_id;
	}
}

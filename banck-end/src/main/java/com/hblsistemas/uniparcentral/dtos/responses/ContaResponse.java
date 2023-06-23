package com.hblsistemas.uniparcentral.dtos.responses;

import java.io.Serializable;

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;

public class ContaResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String numero;
	private String digito;
	private Double saldo;
	private Integer tipoConta;
	private Agencia agenciaId;
	private Pessoa titularId;
	
	public ContaResponse() { }

	public ContaResponse(Long id, String numero, String digito, Double saldo, Integer tipoConta, Agencia agenciaId,
			Pessoa titularId) {
		super();
		this.id = id;
		this.numero = numero;
		this.digito = digito;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.agenciaId = agenciaId;
		this.titularId = titularId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Agencia getAgenciaId() {
		return agenciaId;
	}

	public void setAgenciaId(Agencia agenciaId) {
		this.agenciaId = agenciaId;
	}

	public Pessoa getTitularId() {
		return titularId;
	}

	public void setTitularId(Pessoa titularId) {
		this.titularId = titularId;
	}
}

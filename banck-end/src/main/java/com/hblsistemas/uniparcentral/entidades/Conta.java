package com.hblsistemas.uniparcentral.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String registroAluno;
	private Instant dataCadastro;
	private String numero;
	private String digito;
	private Double saldo;
	private Integer tipoConta;
	
	@ManyToOne
	private Agencia agencia;
	
	@ManyToOne
	private Pessoa titular;
	
	public Conta() { }

	public Conta(Long id, String registroAluno, Instant dataCadastro, String numero, String digito, Double saldo,
			Integer tipoConta, Agencia agencia, Pessoa titular) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.dataCadastro = dataCadastro;
		this.numero = numero;
		this.digito = digito;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.agencia = agencia;
		this.titular = titular;
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

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Pessoa getTitular() {
		return titular;
	}

	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}
}

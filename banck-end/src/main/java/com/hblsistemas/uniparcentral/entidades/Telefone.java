package com.hblsistemas.uniparcentral.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.entidades.enums.TipoOperadora;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String registroAluno;
	private Instant dataCadastro;
	private String numero;
	private Integer tipoOperadora;
	
	@ManyToOne
	private Agencia titularAgencia;
	
	@ManyToOne
	private Pessoa titularPessoa;
	
	public Telefone() { }

	public Telefone(Long id, String registroAluno, Instant dataCadastro, String numero, TipoOperadora tipoOperadora,
			Agencia titularAgencia, Pessoa titularPessoa) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.dataCadastro = dataCadastro;
		this.numero = numero;
		this.tipoOperadora = tipoOperadora.getCodigo();
		this.titularAgencia = titularAgencia;
		this.titularPessoa = titularPessoa;
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

	public TipoOperadora getTipoOperadora() {
		return TipoOperadora.paraEnum(tipoOperadora);
	}

	public void setTipoOperadora(TipoOperadora tipoOperadora) {
		this.tipoOperadora = tipoOperadora.getCodigo();
	}

	public Agencia getTitularAgencia() {
		return titularAgencia;
	}

	public void setTitularAgencia(Agencia titularAgencia) {
		this.titularAgencia = titularAgencia;
	}

	public Pessoa getTitularPessoa() {
		return titularPessoa;
	}

	public void setTitularPessoa(Pessoa titularPessoa) {
		this.titularPessoa = titularPessoa;
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
		Telefone other = (Telefone) obj;
		return Objects.equals(id, other.id);
	}
}

package com.hblsistemas.uniparcentral.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.hblsistemas.uniparcentral.entidades.enums.TipoTransacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String registroAluno;
	private Instant dataCadastro;
	private Instant dataHora;
	private Double valor;
	private Integer tipoTransacao;
	
	@ManyToOne
	private Conta contaOrigem;
	
	@ManyToOne
	private Conta contaDestino;
	
	public Transacao() { }

	public Transacao(Long id, String registroAluno, Instant dataCadastro, Instant dataHora, Double valor,
			TipoTransacao tipoTransacao, Conta contaOrigem, Conta contaDestino) {
		super();
		this.id = id;
		this.registroAluno = registroAluno;
		this.dataCadastro = dataCadastro;
		this.dataHora = dataHora;
		this.valor = valor;
		this.tipoTransacao = tipoTransacao.getCodigo();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
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

	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.paraEnum(tipoTransacao);
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao.getCodigo();
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(id, other.id);
	}
}

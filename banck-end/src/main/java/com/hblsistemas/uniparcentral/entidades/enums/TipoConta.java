package com.hblsistemas.uniparcentral.entidades.enums;

public enum TipoConta {
	
	CONTA_CORRENTE(1, "Conta Corrente"),
	CONTA_POUPANCA(2, "Conta Polpança"),
	CONTA_SALARIO(3, "Conta Salário");
	
	private Integer codigo;
	private String descricao;
	
	private TipoConta(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoConta paraEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoConta op : TipoConta.values()) {
			if (op.getCodigo().equals(codigo)) {
				return op;
			}
		}
		
		// throw new IllegalArgumentException("Código inválido! Código: " + codigo);
		// provisório
		return TipoConta.CONTA_CORRENTE;
	}
}

package com.hblsistemas.uniparcentral.entidades.enums;

public enum TipoOperacao {
	ENTRADA(1, "Operação de entrada"),
	SAIDA(2, "Operação de saída");
	
	private Integer codigo;
	private String descricao;
	
	private TipoOperacao(Integer codigo, String descricao) {
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
	
	public static TipoOperacao paraEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoOperacao op : TipoOperacao.values()) {
			if (op.getCodigo().equals(codigo)) {
				return op;
			}
		}
		
		throw new IllegalArgumentException("Código inválido! Código: " + codigo);
	}
}

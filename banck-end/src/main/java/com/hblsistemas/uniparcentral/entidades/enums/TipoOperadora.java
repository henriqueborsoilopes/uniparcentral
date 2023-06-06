package com.hblsistemas.uniparcentral.entidades.enums;

public enum TipoOperadora {
	
	TIM(1, 	"Tim"),
	VIVO(2, "Vivo"),
	CLARO(3, "Claro"),
	OI(4, "Oi");
	
	private Integer codigo;
	private String descricao;
	
	private TipoOperadora(Integer codigo, String descricao) {
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
	
	public static TipoOperadora paraEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoOperadora op : TipoOperadora.values()) {
			if (op.getCodigo().equals(codigo)) {
				return op;
			}
		}
		
		throw new IllegalArgumentException("Código inválido! Código: " + codigo);
	}
}

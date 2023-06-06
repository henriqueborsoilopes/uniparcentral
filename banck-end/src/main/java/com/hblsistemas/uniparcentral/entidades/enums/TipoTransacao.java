package com.hblsistemas.uniparcentral.entidades.enums;

public enum TipoTransacao {
	
	TRANSFER_PIX(1, "Transferência via Pix"),
	TRANSFER_TED(2, "Transferência via TED"),
	TRANSFER_EMPRESTIMO(3, "Transferência via Emprétimo");
	
	private Integer codigo;
	private String descricao;
	
	private TipoTransacao(Integer codigo, String descricao) {
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
	
	public static TipoTransacao paraEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoTransacao op : TipoTransacao.values()) {
			if (op.getCodigo().equals(codigo)) {
				return op;
			}
		}
		
		throw new IllegalArgumentException("Código inválido! Código: " + codigo);
	}
}

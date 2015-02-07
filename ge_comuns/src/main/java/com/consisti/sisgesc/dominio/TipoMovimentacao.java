package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoMovimentacao {
    
	E("ENTRADA") /* tipoMovimentacao.E=Entrada */,
	S("SA�DA") /* tipoMovimentacao.S=Saida */;

	private String descricao;
	
	TipoMovimentacao(String descricao){
		this.descricao=descricao;
	}
	
    /**
     * @return Retorna o codigo.
     */
	public String getCodigo() {
		return this.toString();
	}

	public String getDescricao() {
		return descricao;
	}

}

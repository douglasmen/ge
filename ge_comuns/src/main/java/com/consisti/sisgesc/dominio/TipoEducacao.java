package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoEducacao {
    
	I("INFANTIL") /* tipoEducacao.I=Infantil */,
	F("FUNDAMENTAL")/* tipoEducacao.F=Fundamental */;

	private String descricao;
	
	TipoEducacao(String descricao){
		this.descricao = descricao;
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

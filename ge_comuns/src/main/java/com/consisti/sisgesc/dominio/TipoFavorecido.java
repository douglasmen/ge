package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoFavorecido {
    
	F("F�SICA")/* tipoFavorecido.F=F�SICA */,
	J("JUR�DICA") /* tipoFavorecido.J=JUR�DICA */,
	I("IMPOSTO") /* tipoFavorecido.I=IMPOSTO */;

	private String descricao;
	
	TipoFavorecido(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
    /**
     * @return Retorna o codigo.
     */
	public String getCodigo() {
		return this.toString();
	}
	
}

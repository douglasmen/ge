package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoPessoa {
    
	F("F�SICA") /* TipoPessoa.F=F�sica */,
	J("JUR�DICA")/* TipoPessoa.J=Jur�dica */;

	private String descricao;
	
	TipoPessoa(String descricao){
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

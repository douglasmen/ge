package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoResidencia {
    
	PQ ("") /* tipoResidencia.PQ=Pr�pia Quitada */,
	PF ("")/* tipoResidencia.PF=Pr�pia Financiada */,
	AL ("")/* tipoResidencia.AL=Alugada */,
	FA ("")/* tipoResidencia.FA=Fam�liar */,
	CE ("")/* tipoResidencia.CE=Cedida */;

	private String descricao;
	
	TipoResidencia(String descricao){
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

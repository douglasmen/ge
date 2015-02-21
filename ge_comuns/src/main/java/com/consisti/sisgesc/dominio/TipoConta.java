package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoConta {
    
	C("CONTA CORRENTE") /* tipoConta.C=Conta corrente */,
	P("POUPAN�A") /* tipoConta.P=Poupan�a */,
	D("DINHEIRO") /* tipoConta.D=DINHEIRO */;

	private String descricao;
	
	TipoConta(String descricao){
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
package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum PeriodoServico {
    
	M("Mensal") /* periodoServico.M=Mensal */,
	D("Di�rio") /* periodoServico.D=Di�rio */;

	private String descricao;
	
	PeriodoServico(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
    /**
     * @return Retorna o codigo.
     */
	public String getCodigo() {
		return this.toString();
	}
	
}

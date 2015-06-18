package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum PeriodoAluno {

	E("ESPECIAL") /* periodoAluno.E=Especial */,
	I("INTEGRAL") /* periodoAluno.I=Integral */,
	M("MANH�") /* periodoAluno.M=Manha */,
	T("TARDE") /* periodoAluno.T=Tarde */;

	private String descricao;
	
	PeriodoAluno(String descricao) {
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

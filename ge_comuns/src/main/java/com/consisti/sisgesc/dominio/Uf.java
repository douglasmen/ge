package com.consisti.sisgesc.dominio;

/**
 * Enum de dom�nio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum Uf {
    
	AC("ACRE") /* uf.AC=AC */,
	AL("ALAGOAS") /* uf.AL=AL */,
	AP("AMAP�") /* uf.AP=AP */,
	AM("AMAZONAS") /* uf.AM=AM */,
	BA("BAHIA") /* uf.BA=BA */,
	CE("CEAR�") /* uf.CE=CE */,
	DF("DISTRITO FEDERAL") /* uf.DF=DF */,
	ES("ESP�RITO SANTO") /* uf.ES=ES */,
	GO("GOI�S") /* uf.GO=GO */,
	MA("MARANH�O") /* uf.MA=MA */,
	MT("MATO GROSSO") /* uf.MT=MT */,
	MS("MATO GROSSO DO SUL") /* uf.MS=MS */,
	MG("MINAS GERAIS") /* uf.MG=MG */,
	PA("PAR�") /* uf.PA=PA */,
	PB("PARA�BA") /* uf.PB=PB */,
	PR("PARAN�") /* uf.PR=PR */,
	PE("PERNAMBUCO") /* uf.PE=PE */,
	PI("P�AUI") /* uf.PI=PI */,
	RJ("RIO DE JANEIRO") /* uf.RJ=RJ */,
	RN("RIO GRANDE DO NORTE") /* uf.RN=RN */,
	RS("RIO GRANDE DO SUL") /* uf.RS=RS */,
	RO("ROND�NIA") /* uf.RO=RO */,
	RR("ROR�IMA") /* uf.RR=RR */,
	SC("SANTA CATARINA") /* uf.SC=SC */,
	SP("S�O PAULO") /* uf.SP=SP */,
	SE("SERGIPE") /* uf.SE=SE */,
	TO("TOCANTINS") /* uf.TO=TO */;

	public String descricao;
	
	Uf(String descricao){
		this.descricao = descricao;
	}
	
    /**
     * @return Retorna o codigo.
     */
	public String getCodigo() {
		return this.toString();
	}

	/**
	 * Retorna a descricao do UF
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}
	
}

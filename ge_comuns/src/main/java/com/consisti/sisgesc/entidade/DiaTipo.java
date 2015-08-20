package com.consisti.sisgesc.entidade;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.powerlogic.jcompany.comuns.PlcBaseVO;
import com.powerlogic.jcompany.dominio.valida.PlcValFormatoSimples;
import com.powerlogic.jcompany.dominio.valida.PlcValidacaoUnificada;
import com.powerlogic.jcompany.dominio.valida.PlcValFormatoSimples.FormatoSimples;

@MappedSuperclass
@PlcValidacaoUnificada
public abstract class DiaTipo extends PlcBaseVO {

	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_DIA_TIPO")
	@Column (name = "ID_DIA_TIPO", nullable=false, length=5)
	private Long id;
	
	@PlcValFormatoSimples(formato=FormatoSimples.MAIUSCULO)
	@Column (name = "DESCRICAO_DIA", nullable=false, length=50)
	private String descricaoDia;
	
	@Column (name = "COR", nullable=false, length=10)
	private String cor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getDescricaoDia() {
		return descricaoDia;
	}

	public void setDescricaoDia(String descricaoDia) {
		this.descricaoDia=descricaoDia;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor=cor;
	}

}

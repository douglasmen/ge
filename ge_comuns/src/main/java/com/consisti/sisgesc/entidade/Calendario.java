package com.consisti.sisgesc.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.Valid;

import com.powerlogic.jcompany.comuns.PlcBaseVO;
import com.powerlogic.jcompany.dominio.valida.PlcValidacaoUnificada;

@MappedSuperclass
@PlcValidacaoUnificada
public abstract class Calendario extends PlcBaseVO {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_CALENDARIO")
	@Column (name = "ID_CALENDARIO", nullable=false, length=5)
	private Long id;
	
	@OneToMany (targetEntity = DiasSemAulaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="calendario")
	@ForeignKey(name="FK_DIA_SEM_AULA")
	@Valid
	@JoinColumn (name = "ID_CALENDARIO")
	private List<DiasSemAula> diasSemAulas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public List<DiasSemAula> getDiasSemAulas() {
		return diasSemAulas;
	}

	public void setDiasSemAulas(List<DiasSemAula> diasSemAulas) {
		this.diasSemAulas = diasSemAulas;
	}

}

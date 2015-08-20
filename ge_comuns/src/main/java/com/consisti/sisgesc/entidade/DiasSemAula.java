package com.consisti.sisgesc.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;
import com.powerlogic.jcompany.comuns.PlcBaseVO;
import com.powerlogic.jcompany.dominio.valida.PlcValidacaoUnificada;

@MappedSuperclass
@PlcValidacaoUnificada
public abstract class DiasSemAula extends PlcBaseVO {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_DIAS_SEM_AULA")
	@Column (name = "ID_DIAS_SEM_AULA", nullable=false, length=5)
	private Long id;
	
	@Column (name = "DIA_SEM_AULA", nullable=false, length=11)
	@Temporal(TemporalType.TIMESTAMP)
	private Date diaSemAula;
	
	@ManyToOne (targetEntity = DiaTipoEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_DIASSEMAULA_DIATIPO")
	@JoinColumn (name = "ID_DIA_TIPO", nullable=false)
	private DiaTipo diaTipo;
	
	@ManyToOne (targetEntity = CalendarioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CALENDARIO")
	@JoinColumn (name = "ID_CALENDARIO", nullable=false)
	private Calendario calendario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public Date getDiaSemAula() {
		return diaSemAula;
	}

	public void setDiaSemAula(Date diaSemAula) {
		this.diaSemAula=diaSemAula;
	}

	public DiaTipo getDiaTipo() {
		return diaTipo;
	}

	public void setDiaTipo(DiaTipo diaTipo) {
		this.diaTipo=diaTipo;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

}

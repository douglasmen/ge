package com.consisti.sisgesc.entidade;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.AccessType;
import javax.persistence.Entity;
/**
 * Classe Concreta gerada a partir do assistente
 */
@Entity
@Table(name="DIAS_SEM_AULA")
@SequenceGenerator(name="SE_DIAS_SEM_AULA", sequenceName="SE_DIAS_SEM_AULA")
@AccessType("field")


@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name="DiasSemAulaEntity.querySelLookup", query="select new DiasSemAulaEntity (obj.id, obj.diaSemAula) from DiasSemAulaEntity obj where obj.id = ? order by obj.id asc")
})
public class DiasSemAulaEntity extends DiasSemAula {
 	
    /*
     * Construtor padrão
     */
    public DiasSemAulaEntity() {
    }
    /*
     * Métodos GET/SET auxiliares gerados automaticamente pelo jCompany
     */
    protected static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    static { formatter.setLenient(false); }
    
    private transient String diaSemAulaStr = null;
    
    public String getDiaSemAulaStr() {
       Date diaSemAulaStr = getDiaSemAula();
       return diaSemAulaStr != null ? formatter.format(diaSemAulaStr) : this.diaSemAulaStr;
    }
    public void setDiaSemAulaStr(String diaSemAulaStr) {
       setDiaSemAula(null);
       this.diaSemAulaStr = diaSemAulaStr;
       if (diaSemAulaStr != null && diaSemAulaStr.trim().length() > 0) {
          try {
             setDiaSemAula(formatter.parse(diaSemAulaStr));
          } catch (Exception e) {}
       }
    }

	public DiasSemAulaEntity(Long id, java.util.Date diaSemAula) {
		this.setId(id);
		this.setDiaSemAula(diaSemAula);
	}
	@Override
	public String toString() {
		return getDiaSemAulaStr();
	}

	@javax.persistence.Transient
	public Class[] getAgregadosLazyPlc() {
		return new Class[] {com.consisti.sisgesc.entidade.DiaTipo.class};
	}

}

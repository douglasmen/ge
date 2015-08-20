package com.consisti.sisgesc.entidade;


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
@Table(name="CALENDARIO_ANUAL")
@SequenceGenerator(name="SE_CALENDARIO", sequenceName="SE_CALENDARIO")
@AccessType("field")


@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name="CalendarioEntity.queryMan", query="from CalendarioEntity obj"),
	@NamedQuery(name="CalendarioEntity.querySel", query="select new CalendarioEntity(obj.id) from CalendarioEntity obj order by obj.id asc"),
	@NamedQuery(name="CalendarioEntity.querySelLookup", query="select new CalendarioEntity (obj.id) from CalendarioEntity obj where obj.id = ? order by obj.id asc")
})
public class CalendarioEntity extends Calendario {
 	
    /*
     * Construtor padrão
     */
    public CalendarioEntity() {
    }
	public CalendarioEntity(Long id) {
		this.setId(id);
	}
	@Override
	public String toString() {
		return getIdAux();
	}

}

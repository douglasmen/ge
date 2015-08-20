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
@Table(name="DIA_TIPO")
@SequenceGenerator(name="SE_DIA_TIPO", sequenceName="SE_DIA_TIPO")
@AccessType("field")


@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name="DiaTipoEntity.queryMan", query="from DiaTipoEntity obj"),
	@NamedQuery(name="DiaTipoEntity.querySelLookup", query="select new DiaTipoEntity (obj.id, obj.descricaoDia, obj.cor) from DiaTipoEntity obj where obj.id = ? order by obj.id asc")
})
public class DiaTipoEntity extends DiaTipo {
 	
    /*
     * Construtor padrão
     */
    public DiaTipoEntity() {
    }
    /*
     * Métodos GET/SET auxiliares gerados automaticamente pelo jCompany
     */
    private transient String descricaoDiaStr;

    public String getDescricaoDiaStr()   {
       if (getDescricaoDia() != null) 
           return( getDescricaoDia() + "" );
       else
           return "";
    }
    
    public void setDescricaoDiaStr( String novoDescricaoDiaStr )   {
        descricaoDiaStr = novoDescricaoDiaStr;
        if (descricaoDiaStr != null && !descricaoDiaStr.equals("") && 
	    org.apache.commons.lang.math.NumberUtils.isNumber(descricaoDiaStr)) 
            setDescricaoDia(descricaoDiaStr);
        if (descricaoDiaStr.equals("")) 
            setDescricaoDia(null);
    }

	public DiaTipoEntity(Long id, String descricaoDia, String cor) {
		this.setId(id);
		this.setDescricaoDia(descricaoDia);
		this.setCor(cor);
	}
	@Override
	public String toString() {
		return getDescricaoDiaStr();
	}

}

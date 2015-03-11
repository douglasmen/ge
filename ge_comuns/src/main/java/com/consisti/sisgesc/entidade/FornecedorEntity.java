package com.consisti.sisgesc.entidade;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.AccessType;

import com.consisti.sisgesc.dominio.AtivoInativo;
import com.consisti.sisgesc.dominio.TipoFavorecido;
/**
 * Classe Concreta gerada a partir do assistente
 */
@Entity
@Table(name="FORNECEDOR")
@SequenceGenerator(name="SE_FORNECEDOR", sequenceName="SE_FORNECEDOR")
@AccessType("field")


@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name="FornecedorEntity.querySel2", query="select new FornecedorEntity(obj.id) from FornecedorEntity obj order by obj.id asc"),
	@NamedQuery(name="FornecedorEntity.queryMan", query="from FornecedorEntity obj"),
	@NamedQuery(name="FornecedorEntity.querySel", query="select new FornecedorEntity(obj.id, obj.tipoPessoa, obj.telefoneContato, obj.nome, obj.razaoSocial, obj.status, obj.nomeFantasia) from FornecedorEntity obj order by obj.telefoneContato, obj.nome asc, obj.razaoSocial asc, obj.nomeFantasia asc"),
	@NamedQuery(name="FornecedorEntity.querySelLookup", query="select new FornecedorEntity (obj.id, obj.nome, obj.nomeFantasia, obj.razaoSocial) from FornecedorEntity obj where obj.id = ? order by obj.id asc")
})
public class FornecedorEntity extends Fornecedor {
 	
	private transient String cpfCnpj;
	
    /*
     * Construtor padrão
     */
    public FornecedorEntity() {
    }
	public FornecedorEntity(Long id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}
	
	public FornecedorEntity(Long id, String nome, String nomeFantasia, String razaoSocial) {
		this.setId(id);
		this.setNome(nome);
		this.setNomeFantasia(nomeFantasia);
		this.setRazaoSocial(razaoSocial);
	}
	
	public FornecedorEntity(String cpfCnpj, Long id) {
		this.setId(id);
		this.setCpfCnpj(cpfCnpj);
	}
	
	@Override
	public String toString() {
		return StringUtils.isNotEmpty(getNome()) ? getNome() : StringUtils.isNotEmpty(getNomeFantasia()) ? getNomeFantasia() : StringUtils.isNotEmpty(getRazaoSocial()) ? getRazaoSocial() : "";
		
	}

	public FornecedorEntity(Long id, TipoFavorecido tipoPessoa, String telefoneContato, String nome, String razaoSocial, AtivoInativo status) {
		setId(id);
		setTipoPessoa(tipoPessoa);
		setTelefoneContato(telefoneContato);
		setNome(nome);
		setRazaoSocial(razaoSocial);
		setStatus(status);
	}

	public FornecedorEntity(Long id, TipoFavorecido tipoPessoa, String telefoneContato, String nome, String razaoSocial, AtivoInativo status, String nomeFantasia) {
		this.setId(id);
		this.setTipoPessoa(tipoPessoa);
		this.setTelefoneContato(telefoneContato);
		this.setNome(nome);
		this.setRazaoSocial(razaoSocial);
		this.setStatus(status);
		this.setNomeFantasia(nomeFantasia);
	}
	public FornecedorEntity(Long id) {
		setId(id);
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
}

package com.consisti.sisgesc.modelo;

import java.util.Date;
import java.util.List;

import com.consisti.sisgesc.entidade.financeiro.ContaPagar;
import com.consisti.sisgesc.entidade.financeiro.ContaReceber;
import com.consisti.sisgesc.persistencia.hibernate.ContaPagarDAO;
import com.consisti.sisgesc.persistencia.hibernate.ContaReceberDAO;
import com.powerlogic.jcompany.comuns.PlcException;

public class ExtratoContasManager extends AppManager {

	private ContaPagarDAO contaPagarDAO;
	private ContaReceberDAO contaReceberDAO;
	
	public ExtratoContasManager(ContaPagarDAO contaPagarDAO, ContaReceberDAO contaReceberDAO) {
		this.contaPagarDAO = contaPagarDAO;
		this.contaReceberDAO = contaReceberDAO;
	}
	
	public List<ContaPagar> recuperaContaPagar(Date dataInicio, Date dataFim) throws PlcException{
		return contaPagarDAO.recuperarAllContaPagar(dataInicio, dataFim);
	}
	
	public List<ContaReceber> recuperaContaReceber(Date dataInicio, Date dataFim) throws PlcException {
		return contaReceberDAO.recuperarAllContaReceber(dataInicio, dataFim);
	}

}

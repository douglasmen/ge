package com.consisti.sisgesc.controle.jsf.diatipo;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.consisti.sisgesc.comuns.AppConstantesComuns;
import com.consisti.sisgesc.controle.jsf.AppAction;
import com.consisti.sisgesc.entidade.DiaTipo;
import com.powerlogic.jcompany.comuns.PlcBaseVO;
import com.powerlogic.jcompany.comuns.PlcException;

/**
 * Classe de Controle gerada pelo assistente
 */
public class DiaTipoAction extends AppAction  {

	@Override
	protected void trataBotoesConformeLogicaApos() throws PlcException {
		// TODO Auto-generated method stub
		super.trataBotoesConformeLogicaApos();
	}
	
	@Override
	protected boolean gravaTabularAntes() throws PlcException {
		Iterator<PlcBaseVO> itens = logicaItensPlc.getItensPlc().iterator();
		while (itens.hasNext()) {
			PlcBaseVO plcBaseVO = (PlcBaseVO) itens.next();
			DiaTipo diaTipo = (DiaTipo) plcBaseVO;
			if ((AppConstantesComuns.COR_EM_BRANCO.equals(diaTipo.getCor()) || StringUtils.isEmpty(diaTipo.getCor())) 
					&& StringUtils.isNotEmpty(diaTipo.getDescricaoDia())){
				throw new PlcException("escolha.cor.para.descricao", new Object[]{diaTipo.getDescricaoDia()});
			} 
		}
		
		return super.gravaTabularAntes();
	}
	
}

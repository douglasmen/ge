/** ******************************** LÓGICA-PADRÃO: TABULAR *************************************
 *  ******************************************************************************************/
	
/**
 * Meta-dados para a camada de controle. Define preferências e inversões de controle de uso somente da camada controle
 */	
@PlcConfigGrupoControle(

	action = com.consisti.sisgesc.controle.jsf.diatipo.DiaTipoAction.class,
	
	/**
	 * Usa layout universal
	 */	
	layoutUniversal = @PlcConfigLayoutUniversal(
						dirBaseFacelets = "/WEB-INF/fcls/diatipo"
						),


	tabular = @PlcConfigTabular(
				propReferenciaDesprezar = "descricaoDia",
				testaDuplicataFlagDesprezar = true,
				numeroNovos = 4)
				
	
,
		comportamento = @PlcConfigComportamento(detalheLembra = true)
)
	
//Gerado em 17/08/2015 20:35 por jCompany Code Generator
package com.powerlogic.jcompany.config.app.diatipotab;

import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigGrupoControle;
import com.powerlogic.jcompany.config.comuns.PlcConfigComportamento;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigTabular;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigLayoutUniversal;

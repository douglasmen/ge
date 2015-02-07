/** ******************************** L�GICA-PADR�O: TABULAR *************************************
 *  ******************************************************************************************/
	
/**
 * Meta-dados para a camada de controle. Define prefer�ncias e invers�es de controle de uso somente da camada controle
 */	
@PlcConfigGrupoControle(

	action = com.consisti.sisgesc.controle.jsf.CDU004.DisciplinasAction.class,
	
	/**
	 * Usa layout universal
	 */	
	layoutUniversal = @PlcConfigLayoutUniversal(
						dirBaseFacelets = "/WEB-INF/fcls/CDU004"
						),


	tabular = @PlcConfigTabular(
				propReferenciaDesprezar = "descricao",
				testaDuplicataFlagDesprezar = true,
				numeroNovos = 4)
				
	
,
		comportamento = @PlcConfigComportamento(detalheLembra = true)
)
	
//Gerado em 13/03/2013 21:52 por jCompany Code Generator
package com.powerlogic.jcompany.config.app.disciplinastab;

import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigGrupoControle;
import com.powerlogic.jcompany.config.comuns.PlcConfigComportamento;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigTabular;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigLayoutUniversal;

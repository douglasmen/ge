/** ******************************** L�GICA-PADR�O: CRUD *************************************
 *  ******************************************************************************************/
	
/**
 * Meta-dados para a camada de controle. Define prefer�ncias e invers�es de controle de uso somente da camada controle
 */	
@PlcConfigGrupoControle(
		action = com.consisti.sisgesc.controle.jsf.MensalidadesTurmaAction.class,

	/**
	 * Usa layout universal
	 */	
	layoutUniversal = @PlcConfigLayoutUniversal(
						dirBaseFacelets = "/WEB-INF/fcls/"
						)

)
	
//Gerado em 11/06/2015 20:42 por jCompany Code Generator
package com.powerlogic.jcompany.config.app.mensalidadesturmaman;

import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigGrupoControle;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigLayoutUniversal;

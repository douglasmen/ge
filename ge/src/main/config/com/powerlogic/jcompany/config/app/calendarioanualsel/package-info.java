/** ******************************* L�GICA-PADR�O: SELECAO ***********************************
 *  ******************************************************************************************/

/**
 * Meta-dados para a camada de controle. Define prefer�ncias e invers�es de controle de uso somente da camada controle
 */	
@PlcConfigGrupoControle(
		action = com.consisti.sisgesc.controle.jsf.calendarioAnual.CalendarioAnualAction.class,

	/**
	 * Usa layout universal
	 */	
	layoutUniversal = @PlcConfigLayoutUniversal(
						dirBaseFacelets = "/WEB-INF/fcls/calendarioAnual"
						),
	selecao = @PlcConfigSelecao(
				navegador = @PlcConfigNavegador(numPorPagina=20, dinamicoTipo=com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigNavegador.DinamicoTipo.DINAMICO_PAGINA),				argumentos = {
						@PlcConfigArgumento(propriedade="descricao", operador=Operador.LIKE_PERC_FINAL, formato=Formato.STRING),
						@PlcConfigArgumento(propriedade="totalDiasLetivos", operador=Operador.IGUAL_A, formato=Formato.STRING)
			})

)
	
//Gerado em 03/04/2013 16:23 por jCompany Code Generator
package com.powerlogic.jcompany.config.app.calendarioanualsel;

import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigGrupoControle;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigArgumento.Operador;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigArgumento.Formato;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigSelecao;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigArgumento;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigLayoutUniversal;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigNavegador;


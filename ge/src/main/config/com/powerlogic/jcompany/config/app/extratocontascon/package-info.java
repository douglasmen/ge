/** ******************************* L�GICA-PADR�O: CONSULTA ***********************************
 *  ******************************************************************************************/

/**
 * Meta-dados para a camada de controle. Define prefer�ncias e invers�es de controle de uso somente da camada controle
 */	
@PlcConfigGrupoControle(
		action = com.consisti.sisgesc.controle.jsf.financeiro.CDUF007.ExtratoContasAction.class,

	/**
	 * Usa layout universal
	 */	
	layoutUniversal = @PlcConfigLayoutUniversal(
						dirBaseFacelets = "/WEB-INF/fcls/financeiro.CDUF007"
						),
	selecao = @PlcConfigSelecao(
				navegador = @PlcConfigNavegador(numPorPagina=20, dinamicoTipo=com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigNavegador.DinamicoTipo.DINAMICO_PAGINA),				argumentos = {
						@PlcConfigArgumento(propriedade="dataInicio_ArgINI", operador=Operador.MAIOR_OU_IGUAL_QUE, formato=Formato.DATE),
						@PlcConfigArgumento(propriedade="dataFim_ArgINI", operador=Operador.MAIOR_OU_IGUAL_QUE, formato=Formato.DATE)
			})

)
	
//Gerado em 21/07/2014 20:42 por jCompany Code Generator
package com.powerlogic.jcompany.config.app.extratocontascon;

import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigGrupoControle;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigArgumento.Operador;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigArgumento.Formato;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigSelecao;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigArgumento;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigLayoutUniversal;
import com.powerlogic.jcompany.config.controle.colaboracao.PlcConfigNavegador;


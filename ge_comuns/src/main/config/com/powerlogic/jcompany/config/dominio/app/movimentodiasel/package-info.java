/** ******************************* L�GICA-PADR�O: SELECAO ***********************************
 *  ******************************************************************************************/
@PlcConfigGrupoAgregacao(
		entidade = com.consisti.sisgesc.entidade.MovimentoDiaEntity.class,
		classesLookup = {com.consisti.sisgesc.entidade.financeiro.BancoEntity.class},
		padrao = @PlcConfigPadrao(logica = PlcConfigPadrao.Logica.SELECAO,
									complexidade = PlcConfigPadrao.Complexidade.SIMPLES,
									exclusaoModo = PlcConfigPadrao.ExclusaoModo.FISICA)
	)
	
//Gerado em 09/02/2015 20:51 por jCompany Code Generator
package com.powerlogic.jcompany.config.dominio.app.movimentodiasel;

import com.powerlogic.jcompany.config.dominio.PlcConfigGrupoAgregacao;
import com.powerlogic.jcompany.config.dominio.PlcConfigPadrao;

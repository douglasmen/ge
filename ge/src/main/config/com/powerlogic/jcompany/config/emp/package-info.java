/*  																													
	    				   jCompany Developer Suite																		
			    		Copyright (C) 2008  Powerlogic																	
	 																													
	    Este programa � licenciado com todos os seus c�digos fontes. Voc� pode modific�-los e							
	    utiliz�-los livremente, inclusive distribu�-los para terceiros quando fizerem parte de algum aplicativo 		
	    sendo cedido, segundo os termos de licenciamento gerenciado de c�digo aberto da Powerlogic, definidos			
	    na licen�a 'Powerlogic Open-Source Licence 2.0 (POSL 2.0)'.    													
	  																													
	    A Powerlogic garante o acerto de erros eventualmente encontrados neste c�digo, para os clientes licenciados, 	
	    desde que todos os c�digos do programa sejam mantidos intactos, sem modifica��es por parte do licenciado. 		
	 																													
	    Voc� deve ter recebido uma c�pia da licen�a POSL 2.0 juntamente com este programa.								
	    Se n�o recebeu, veja em <http://www.powerlogic.com.br/licencas/posl20/>.										
	 																													
	    Contatos: plc@powerlogic.com.br - www.powerlogic.com.br 														
																														
 */ 
 /** ******************* REDEFINI��ES DE META-DADOS GLOBAIS DA EMPRESA **********************
  ********************** Configura��es default para toda a empresa *************************
  *******************************************************************************************/
			
@PlcConfigEmpresa(nome = "CONSIS-TI", dominio = "www.consisti.com.br", sigla = "FAC", 
			logotipo = "/plc/midia/login-logo-empresa.png", endereco = "",
			emailSuporte = "jaopol@gmail.com",telefoneSuporte = "(31)9214-7924")
			
@PlcConfigAparencia(pele = "azul", layout = "sistema",layoutFormato=LayoutFormato.CSS,
					ajaxUsa = true, destacaCampoFocadoUsa = true , riaUsa="S", parcialAjaxUsa="N")
			    	 
package com.powerlogic.jcompany.config.emp;

import com.powerlogic.jcompany.config.comuns.PlcConfigEmpresa;
import com.powerlogic.jcompany.config.controle.geral.PlcConfigAparencia;
import com.powerlogic.jcompany.config.controle.geral.PlcConfigAparencia.LayoutFormato;


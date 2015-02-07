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
@PlcConfigEmpresa(nome = "Powerlogic SA", dominio = "www.powerlogic.com.br", sigla = "PLC", 
			logotipo = "/plc/midia/login-logo-empresa.png", endereco = "Rua Para�ba, 330 / 19� andar. CEP:30130-917 - Funcionarios - Belo Horizonte/MG",
			emailSuporte = "suporte@powerlogic.com.br",telefoneSuporte = "55 31 3555-0050")
			
@PlcConfigSufixoClasse (entidade="Entity",entidadeGerente="Manager")

@PlcConfigPacote (entidade=".entidade.")
		
package com.powerlogic.jcompany.config.comuns.emp;

import com.powerlogic.jcompany.config.comuns.PlcConfigEmpresa;
import com.powerlogic.jcompany.config.comuns.PlcConfigPacote;
import com.powerlogic.jcompany.config.comuns.PlcConfigSufixoClasse;


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
package com.consisti.sisgesc.controle.listener;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;

import com.powerlogic.jcompany.comuns.PlcException;
import com.powerlogic.jcompany.controle.listener.PlcServletContextListener;
import com.consisti.sisgesc.facade.IAppFacade;

/**
 * Classe destinada a programa��es em tempo de inicializa��o  da aplica��o
 */
public class AppServletContextListener extends PlcServletContextListener {
	
	protected static final Logger log = Logger.getLogger(AppServletContextListener.class);

	@Override
	public void cdAoEncerrarAplicacao(ServletContextEvent event)
			throws PlcException {
		log.info("Encerrando a Aplicacao");

	}

	@Override
	public void ciAoInicializarAplicacao(ServletContextEvent event)
			throws PlcException {
		log.info("Tratamento da Aplicacao: Inicializando a Aplicacao");
	}
	
}

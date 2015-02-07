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

import javax.servlet.http.HttpSessionEvent;

import org.apache.log4j.Logger;

import com.powerlogic.jcompany.controle.PlcConstantes;
import com.powerlogic.jcompany.controle.cache.PlcCacheSessaoVO;
import com.powerlogic.jcompany.controle.listener.PlcHttpSessionListener;

/**
 * rhdemofcls. Classe que implementa o DP "Listener" para Sess�o
 */
public class AppHttpSessionListener extends PlcHttpSessionListener {
	/**
	 * rhdemofcls: Realiza procedimentos no momento de encerramento de cada Sess�o 
	 */
    @Override
	public void aoEncerrarSessao (HttpSessionEvent event) {
		
		log.debug("Aplicacao: Encerrando Sessao");
	}
	
	/**
	 *  rhdemofcls: Realiza procedimentos no momento de inicializa��o de cada Sess�o 
	 */
    @Override
	public void aoInicializarSessao (HttpSessionEvent event,PlcCacheSessaoVO plcSessao) {
						
		Logger log = Logger.getLogger(this.getClass());
		
		log.debug("Aplicacao: Iniciando Sessao");
		
		// Coloca Javascript do jcompany
		event.getSession().setAttribute(PlcConstantes.JAVASCRIPT.JAVASCRIPT_JCOMPANY,"/plc/javascript/PlcGeral.js");
		// Coloca Javascript complementar da aplica��o
		event.getSession().setAttribute(PlcConstantes.JAVASCRIPT.JAVASCRIPT_ESPECIFICO,"/plc/javascript/AppGeral.js");
		// Coloca CSS default
		event.getSession().setAttribute(PlcConstantes.GUI.PELE.CSS_ESPECIFICO,"/plc/css-w2/" + plcSessao.getPele() +"/PlcPele.css");
		// Coloca CSS default para 256 cores, ou seja, m�quinas com monitores com baixa resolu��o
		// Os layouts do jCompany ir�o comutar automaticamente entre um e outro
		event.getSession().setAttribute(PlcConstantes.GUI.PELE.CSS_ESPECIFICO_256,"/plc/css-w2/" + plcSessao.getPele() +"/PlcPele256.css");
		
		// JSF - Coloca informacoes de leiaute na sessao
		plcSessao.setIndLayoutReduzido("N");
		event.getSession().setAttribute(PlcConstantes.SESSION_CACHE_KEY,plcSessao);
		
		// Auxiliar provisorio para manter compatibilidade
		event.getSession().setAttribute("contextPathPlc","./../");

	}
}

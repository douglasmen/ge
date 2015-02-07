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
package com.consisti.sisgesc.controle.tiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.beans.SimpleMenuItem;

import com.consisti.sisgesc.entidade.autenticacao.PerfilEntity;
import com.consisti.sisgesc.facade.IAppFacade;
import com.powerlogic.jcompany.comuns.PlcException;
import com.powerlogic.jcompany.config.PlcConfigHelper;
import com.powerlogic.jcompany.config.comuns.PlcConfigEjbFacadeRef;
import com.powerlogic.jcompany.controle.PlcConstantes;
import com.powerlogic.jcompany.controle.PlcControleLocator;
import com.powerlogic.jcompany.controle.PlcFacadeTipo;
import com.powerlogic.jcompany.controle.tiles.PlcMenuItemController;

/**
* sisgesc . Exemplo de l�gica de controle aplicada aos �tens de menu. 
*/
public class AppMenuItemController  extends PlcMenuItemController {
	
	/**
 	 * Facade jCompany p/ camada de modelo
 	 */
 	protected IAppFacade iAppFacade = null;
 	
	/**
	 * Exemplo de altera��o dinamica de itens de menu
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void execute (ComponentContext context,
            HttpServletRequest request,
            HttpServletResponse response,
			javax.servlet.ServletContext servletContext)
            throws PlcException	{

		// Pega bloco de itens do contexto Tiles
		@SuppressWarnings("unused")
		List l = (List) context.getAttribute(PlcConstantes.GUI.MENU.TILES_DEF_MENU_ITENS);
		
		// Instanciar colecao transiente, em escopo de sess�o ou requisi�ao.
		//List lNova = new ArrayList();
		
		// Fazer l�gicas para averiguar itens que importam, adicionando o que for preciso
		
		// Incluir a nova cole�ao no contexto
		//context.putAttribute(PlcConstantes.GUI.MENU.TILES_DEF_MENU_ITENS,lNova);
				
		// Nao esquecer de chamar programa��o do framework
		super.execute(context,request,response,servletContext);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List executeMenuItemDinamicoApi(ComponentContext context,
			HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext, List listaItensMenu)
			throws PlcException {
		
		List listaCorreta = new ArrayList();
		//adiciona na nova lista para ser removido
		List listaMenuAtual = new ArrayList();
		listaMenuAtual.addAll( listaItensMenu );
		
		if( listaItensMenu != null ){
			
			List<PerfilEntity> perfil = getServiceFacade().recuperaListaUrlPerfilByLoginUsuario( request.getUserPrincipal().getName() );
			
			if( perfil != null ){
				
				//utilizado para retirar a url que ja foi adicionada
				String urlAdicionada = null;
				
				for (Iterator iterator = perfil.iterator(); iterator.hasNext();) {
					PerfilEntity perfilEntity = (PerfilEntity) iterator.next();
					
					String urlPerfil = new String();	
					//retira as 3 ultimas letras da url (sel ou man)
					if( perfilEntity.getUrlAcesso().contains("man") || perfilEntity.getUrlAcesso().contains("sel") ){
						urlPerfil = perfilEntity.getUrlAcesso().substring( 0, perfilEntity.getUrlAcesso().length() - 3 );
					}
					else{
						urlPerfil = perfilEntity.getUrlAcesso();
					}
					
					for (Iterator iterator2 = listaMenuAtual.iterator(); iterator2.hasNext();) {
						SimpleMenuItem menu = (SimpleMenuItem) iterator2.next();
						
						//verifica se � a url do perfil e se ja foi adicionada para nao adicionar novamente
						if( menu.getLink().contains( perfilEntity.getUrlAcesso() ) 
								&& ( urlAdicionada == null || !urlPerfil.equals( urlAdicionada ) ) ){
							listaCorreta.add( menu );
							iterator2.remove();
							
							urlAdicionada = urlPerfil;
							
							//para adicionar os botoes acesso rapido
							if("turma".equals( urlAdicionada ) ){
								request.setAttribute("exibeBotaoTurma", "S");
							}
							else if( "aluno".equals( urlAdicionada ) ){
								request.setAttribute("exibeBotaoAluno", "S");
							}
							else if( "cronogramaturma".equals( urlAdicionada ) ){
								request.setAttribute("exibeBotaoCronogramaTurma", "S");
							}
							break;
						}
					}
				}
			}
		}
			
		
		return super.executeMenuItemDinamicoApi(context, request, response,
				servletContext, listaCorreta);
	}
	
	 /**
     * Retorna a Interface do Servi�o de Persist�ncia armazenado no escopo
     * da aplica��o
     * 
     * @since jCompany 3.0
     */
    protected IAppFacade getServiceFacade() throws PlcException {
    	
    	if (PlcConfigHelper.getInstance().isEJB()) {
    		if (iAppFacade != null)
    			return iAppFacade;
    		else {
    			try {
    				String prefixoJNDIApp 	= PlcConfigHelper.getInstance().get(PlcConfigEjbFacadeRef.class).nomePrefixoJNDIApp();
    				String ejbref 			= PlcConfigHelper.getInstance().get(PlcConfigEjbFacadeRef.class).nomeFacadeApp();
    				iAppFacade = (IAppFacade) PlcControleLocator.getInstance().getFacade(prefixoJNDIApp + "/"+ejbref, PlcFacadeTipo.EJB);
					if (iAppFacade==null)
						PlcConfigHelper.getInstance().setContainerSuportaEjb(false);
    			} catch (PlcException e) {
    				log.info("#####Nao encontrou Facade EJB usando Facade padrao.", e);
    				throw new PlcException("jcompany.erro.generico", new Object[] {
    						"getServiceFacade", e }, e, log);
    				
    			}
    	   }
	   }
    	
	   if (iAppFacade == null) {
			try {
		    	iAppFacade = (IAppFacade) PlcControleLocator.getInstance().getFacadePadrao();	
	    	} catch (PlcException e) {
	    		throw new PlcException("jcompany.erro.generico", new Object[] { "getServiceFacade", e }, e, log);
	    	}
		}
	
		return iAppFacade;
    }

}

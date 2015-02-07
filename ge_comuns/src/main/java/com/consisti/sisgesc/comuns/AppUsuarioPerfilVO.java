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
package com.consisti.sisgesc.comuns;

import com.powerlogic.jcompany.comuns.PlcBaseUsuarioPerfilVO;
import com.powerlogic.jcompany.dominio.tipo.PlcSimNao;

/**
* sisgesc. Implementar aqui atributos de personaliza��o
* espec�ficos do usuario.
*/
public class AppUsuarioPerfilVO extends PlcBaseUsuarioPerfilVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PlcSimNao usuarioExclui;
	PlcSimNao usuarioPesquisa;
	PlcSimNao usuarioGrava;
	PlcSimNao usuarioProfessor;
	PlcSimNao usuarioAdm;
	String nomeUsuario;
	Long idUsuario;
	Long idFuncionario;
	
	public PlcSimNao getUsuarioExclui() {
		return usuarioExclui;
	}
	public void setUsuarioExclui(PlcSimNao usuarioExclui) {
		this.usuarioExclui = usuarioExclui;
	}
	public PlcSimNao getUsuarioPesquisa() {
		return usuarioPesquisa;
	}
	public void setUsuarioPesquisa(PlcSimNao usuarioPesquisa) {
		this.usuarioPesquisa = usuarioPesquisa;
	}
	public PlcSimNao getUsuarioGrava() {
		return usuarioGrava;
	}
	public void setUsuarioGrava(PlcSimNao usuarioGrava) {
		this.usuarioGrava = usuarioGrava;
	}
	public PlcSimNao getUsuarioProfessor() {
		return usuarioProfessor;
	}
	public void setUsuarioProfessor(PlcSimNao usuarioProfessor) {
		this.usuarioProfessor = usuarioProfessor;
	}
	public PlcSimNao getUsuarioAdm() {
		return usuarioAdm;
	}
	public void setUsuarioAdm(PlcSimNao usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	
	
}

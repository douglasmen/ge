package com.consisti.sisgesc.controle.jsf.financeiro.CDUF006;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;

import com.consisti.sisgesc.controle.jsf.AppAction;
import com.consisti.sisgesc.entidade.financeiro.ContaReceberEntity;
import com.consisti.sisgesc.facade.IAppFacade;
import com.powerlogic.jcompany.comuns.PlcException;
import com.powerlogic.jcompany.config.comuns.PlcConstantes.PlcJsfConstantes.NAVEGACAO;
import com.powerlogic.jcompany.controle.PlcConstantes;
import com.powerlogic.jcompany.dominio.tipo.PlcSimNao;

/**
 * Classe de Controle gerada pelo assistente
 */
@SuppressWarnings("serial")
public class ContaReceberAction extends AppAction  {
	
	private SimpleDateFormat formataDataGravar = new SimpleDateFormat("dd_MM_yyyy");
	
	/* (non-Javadoc)
	 * @see com.consisti.sisgesc.controle.jsf.AppAction#trataBotoesConformeLogicaApos()
	 */
	@Override
	protected void trataBotoesConformeLogicaApos() throws PlcException {
		
		trataBotoes();
		
		super.trataBotoesConformeLogicaApos();
	}

	private void trataBotoes() {
		
		if( entidadePlc != null && entidadePlc.getId() != null ){
			
			contextHelperPlc.getRequest().setAttribute("exibeGeraBoleto", "S");
			contextHelperPlc.getRequest().setAttribute("exibeLiquidaTitulo", "S");
			//Se o titulo estiver quitado
			if( PlcSimNao.S.equals( ((ContaReceberEntity)entidadePlc ).getRecebido() ) ){
				contextHelperPlc.getRequest().setAttribute("exibeLiquidaTitulo", "N");
				contextHelperPlc.getRequest().setAttribute( PlcConstantes.ACAO.EXIBE_BT_GRAVAR, "N");
				contextHelperPlc.getRequest().setAttribute( PlcConstantes.ACAO.EXIBE_BT_EXCLUIR, "N");
			}
			//Se o titulo n�o estiver quitado
			else{
				contextHelperPlc.getRequest().setAttribute("exibeLiquidaTitulo", "S");
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.powerlogic.jcompany.controle.jsf.PlcBaseJsfAction#novoApos()
	 */
	@Override
	protected String novoApos() throws PlcException {
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		contaReceber.setDataDocumento( new Date() );
		contaReceber.setRecebido( PlcSimNao.N);
		contaReceber.setBoletoGerado( PlcSimNao.N);
		
		return super.novoApos();
	}
	
	/* (non-Javadoc)
	 * @see com.powerlogic.jcompany.controle.jsf.PlcBaseJsfAction#gravaSimplesAntes()
	 */
	@Override
	protected boolean gravaSimplesAntes() throws PlcException {
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		validaDataVencimento( contaReceber.getDataVencimento() );

		if( contaReceber.getBoleto() == null ){
			contaReceber.setBoletoGerado( PlcSimNao.N );
		}
		
		return super.gravaSimplesAntes();
	}
	
	/**
	 * Utilizado para gerar o boleto quando clicar no bot�o
	 * @return
	 * @throws PlcException
	 */
	public String gerarBoleto() throws PlcException{
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		validaBanco( contaReceber );
		
		IAppFacade fc = (IAppFacade)getServiceFacade();
		//GerarBoletoUtil gb = new GerarBoletoUtil();
		
		Boleto boleto = fc.gerarBoleta( contaReceber );
		
		 /*
         * GERANDO O BOLETO BANC�RIO.
         */
        // Instanciando um objeto "BoletoViewer", classe respons�vel pela
        // gera��o do boleto banc�rio.
        BoletoViewer boletoViewer = new BoletoViewer(boleto);

        // Gerando o arquivo. No caso o arquivo mencionado ser� salvo na mesma
        // pasta do projeto. Outros exemplos:
        // WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
        // LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
        //File arquivoPdf = boletoViewer.getPdfAsFile("MeuPrimeiroBoleto.pdf");

        // Mostrando o boleto gerado na tela.
        //mostreBoletoNaTela(arquivoPdf);
        
        try {
        	contaReceber.setDataDocumento( new Date() );
        	StringBuffer descricaoBoleto = new StringBuffer();
        	descricaoBoleto.append( contaReceber.getAluno().getMatricula() );
        	descricaoBoleto.append( "_" );
        	descricaoBoleto.append( formataDataGravar.format( contaReceber.getDataDocumento() ) );

			contaReceber.setBoleto( boletoViewer.getPdfAsByteArray() );
			contaReceber.setBoletoGerado(PlcSimNao.S);
			contaReceber.setDataBoleto( new Date() );
			
			downloadArquivo( boletoViewer.getPdfAsByteArray(), descricaoBoleto.toString(), "pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		grava();
		edita();
		
		return NAVEGACAO.IND_MESMA_PAGINA;
	}
	
	/**
	 * Seta o titulo como recebido
	 * @return
	 * @throws PlcException
	 */
	public String liquidaTitulo() throws PlcException{
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		
		if( PlcSimNao.S.equals( contaReceber.getRecebido() ) ){
			throw new PlcException("msg.info.tituloLiquidado");
		}
		
		validaBanco(contaReceber);
		validaDataPagamento( contaReceber.getDataRecebimento() );
		contaReceber.setRecebido( PlcSimNao.S );

		if( contaReceber.getDataRecebimento() == null ){
			contaReceber.setDataRecebimento( new Date() );
		}
		
		grava();
		
		return NAVEGACAO.IND_MESMA_PAGINA;
	}

	/**
	 * Para liquida��o do titulo ou gera��o da boleta o banco � obrigat�rio
	 * @param contaReceber
	 * @throws PlcException
	 */
	private void validaBanco(ContaReceberEntity contaReceber)
			throws PlcException {
		if( contaReceber.getBanco() == null ){
			throw new PlcException("msg.info.informar.banco");
		}
	}
	
}

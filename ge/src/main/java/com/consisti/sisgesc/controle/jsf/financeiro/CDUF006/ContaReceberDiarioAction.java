package com.consisti.sisgesc.controle.jsf.financeiro.CDUF006;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.consisti.sisgesc.controle.jsf.AppAction;
import com.consisti.sisgesc.dominio.TipoContaReceber;
import com.consisti.sisgesc.dominio.TipoReceberDe;
import com.consisti.sisgesc.entidade.AlunoEntity;
import com.consisti.sisgesc.entidade.financeiro.ContaReceberEntity;
import com.consisti.sisgesc.entidade.financeiro.ContaReceberProdutoVenda;
import com.consisti.sisgesc.entidade.financeiro.ProdutoVenda;
import com.powerlogic.jcompany.comuns.PlcException;
import com.powerlogic.jcompany.controle.PlcConstantes.PlcJsfConstantes.NAVEGACAO;
import com.powerlogic.jcompany.dominio.tipo.PlcSimNao;

@SuppressWarnings("serial")
public class ContaReceberDiarioAction extends AppAction {

	//utilizado para identificar a linha editada
	private int indexDet;
	//Usado na edicao devido o campo desabilitado perder o valor na gravacao
	private TipoReceberDe tipoReceberDeAuxEdit;
	
	@Override
	protected boolean gravaSimplesAntes() throws PlcException {
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;

		if(contaReceber.getTipoReceberDe() == null ){
			contaReceber.setTipoReceberDe( getTipoReceberDeAuxEdit() );
		}
		
		setValorPadrao(contaReceber);
		
		
		return super.gravaSimplesAntes();
	}
	
	@Override
	protected String gravaApos() {
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		if(TipoReceberDe.O.equals( contaReceber.getTipoReceberDe() ) ){
			contaReceber.setAluno(new AlunoEntity());
		}
		
		return super.gravaApos();
	}

	/**
	 * @param contaReceber
	 */
	private void setValorPadrao(ContaReceberEntity contaReceber) {
		
		contaReceber.setBoletoGerado(PlcSimNao.N);
		contaReceber.setValorDocumento( contaReceber.getValorTotal() );
		contaReceber.setDataVencimento( contaReceber.getDataRecebimento() );
		contaReceber.setRecebido(PlcSimNao.S);
		contaReceber.setTipoContaReceber( TipoContaReceber.D );
		
		if( TipoReceberDe.O.equals( contaReceber.getTipoReceberDe() ) ){
			contaReceber.setContaReceberProdutoVenda( new ArrayList<ContaReceberProdutoVenda>() );
		}
		else{
			contaReceber.setOutro(null);
		}
		
	}

	@Override
	protected String novoApos() throws PlcException {
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		
		contaReceber.setDataDocumento( new Date() );
		contaReceber.setDataRecebimento( new Date() );
		contaReceber.setTipoReceberDe( TipoReceberDe.A );
		
		return super.novoApos();
	}
	
	@Override
	protected String editaApos() throws PlcException {
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		setTipoReceberDeAuxEdit( contaReceber.getTipoReceberDe() );
		
		return super.editaApos();
	}
	
	/**
	 * Seta o valor unitario do produto escolhido pelo usuario
	 * @return
	 */
	public String setaValorProduto(){
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		
		ProdutoVenda produtoVenda = contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getProdutoVenda();
		
		if(produtoVenda != null){
			if( contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getQuantidadeVendida() == null ){
				contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).setValorUnitario( produtoVenda.getValor());
			}
			else{
				contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).setValorUnitario( produtoVenda.getValor());
				setaValorTotal();
			}
		}
		
		return NAVEGACAO.IND_MESMA_PAGINA;
	}

	/**
	 * Seta o valor total multiplicado pela quantidade informada pelo usuario
	 * @return
	 */
	public String setaValorTotal(){
		
		ContaReceberEntity contaReceber = (ContaReceberEntity)entidadePlc;
		ProdutoVenda produtoVenda = contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getProdutoVenda();
		
		if(produtoVenda != null && contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getQuantidadeVendida() != null){
			
			if(contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getValorTotal() != null){
				//retira valor total do produto alterado
				contaReceber.setValorTotal( contaReceber.getValorTotal().subtract( contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getValorTotal() ) );
			}
			
			Double valorTotal = contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getQuantidadeVendida() *
			contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getValorUnitario().doubleValue();
			contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).setValorTotal( new BigDecimal(valorTotal) );
			setaValorTotalReceber( contaReceber.getContaReceberProdutoVenda().get(getIndexDet()).getValorTotal(), contaReceber );
		}
		
		return NAVEGACAO.IND_MESMA_PAGINA;
	}
	
	
	/**
	 * Seta o valor total do contas a receber
	 * @param valorTotalProduto
	 * @param contaReceber
	 */
	private void setaValorTotalReceber(BigDecimal valorTotalProduto,
			ContaReceberEntity contaReceber) {
		
		if(contaReceber.getValorTotal() == null){
			contaReceber.setValorTotal( BigDecimal.ZERO );
		}
		contaReceber.setValorTotal( contaReceber.getValorTotal().add( valorTotalProduto ) );
		
	}

	public int getIndexDet() {
		return indexDet;
	}

	public void setIndexDet(int indexDet) {
		this.indexDet = indexDet;
	}

	public TipoReceberDe getTipoReceberDeAuxEdit() {
		return tipoReceberDeAuxEdit;
	}

	public void setTipoReceberDeAuxEdit(TipoReceberDe tipoReceberDeAuxEdit) {
		this.tipoReceberDeAuxEdit = tipoReceberDeAuxEdit;
	}
	
}

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
package com.consisti.sisgesc.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jrimum.bopepo.Boleto;

import com.consisti.sisgesc.comuns.AppBaseContextVO;
import com.consisti.sisgesc.entidade.AlunoEntity;
import com.consisti.sisgesc.entidade.BoletimFundamentalDetEntity;
import com.consisti.sisgesc.entidade.BoletimFundamentalEntity;
import com.consisti.sisgesc.entidade.ContratoEntity;
import com.consisti.sisgesc.entidade.CronogramaTurma;
import com.consisti.sisgesc.entidade.Disciplinas;
import com.consisti.sisgesc.entidade.EnderecoEntity;
import com.consisti.sisgesc.entidade.FornecedorEntity;
import com.consisti.sisgesc.entidade.FuncionarioEntity;
import com.consisti.sisgesc.entidade.RegistroNotasFundamentalEntity;
import com.consisti.sisgesc.entidade.ResponsavelFinanceiroAlunoEntity;
import com.consisti.sisgesc.entidade.ServicoAluno;
import com.consisti.sisgesc.entidade.ServicosEntity;
import com.consisti.sisgesc.entidade.Turma;
import com.consisti.sisgesc.entidade.TurmaEntity;
import com.consisti.sisgesc.entidade.autenticacao.PerfilEntity;
import com.consisti.sisgesc.entidade.autenticacao.UsuarioEntity;
import com.consisti.sisgesc.entidade.financeiro.BancoEntity;
import com.consisti.sisgesc.entidade.financeiro.ContaPagar;
import com.consisti.sisgesc.entidade.financeiro.ContaReceber;
import com.consisti.sisgesc.entidade.financeiro.ContaReceberEntity;
import com.consisti.sisgesc.entidade.financeiro.TipoPlanoContasEntity;
import com.powerlogic.jcompany.comuns.PlcBaseVO;
import com.powerlogic.jcompany.comuns.PlcException;
import com.powerlogic.jcompany.comuns.facade.IPlcFacade;

/**
 * sisgesc . Interface de persist�ncia.
 */
/**
 * @author joaopaulo
 *
 */
public interface IAppFacade extends IPlcFacade {
	
	/**
	 * Recupera a lista de urls do perfil pelo login do usuario
	 * @param login
	 * @return List<PerfilEntity>
	 * @throws PlcException
	 */
	List<PerfilEntity> recuperaListaUrlPerfilByLoginUsuario( String login ) throws PlcException;

	/**
	 * Recupera o perfil pelo login do usuario
	 * @param login
	 * @return PerfilEntity
	 * @throws PlcException
	 */
	PerfilEntity recuperaPerfilUsuarioByLoginUsuario( String login ) throws PlcException;
	
	/**
	 * Recupera o Servi�o pelo id
	 * @param idServico
	 * @return
	 * @throws PlcException
	 */
	ServicosEntity recuperaServico( Long idServico ) throws PlcException;
	
	/**
	 * Recupera a lista de aluno da turma
	 * @param turma
	 * @return List<AlunoEntity>
	 * @throws PlcException
	 */
	List<AlunoEntity> recuperaAlunoPelaTurma( Turma turma ) throws PlcException;
	
	/**
	 * Utilizado para recuperar as disciplinas do aluno
	 * @param idAluno
	 * @return List<Disciplinas>
	 * @throws PlcException
	 */
	List<Disciplinas> recuperaDisciplinasByIdAluno( Long idAluno ) throws PlcException;

	/**
	 * Recupera lista de disciplinas do aluno
	 * @param idTurma
	 * @return
	 * @throws PlcException
	 */
	List<CronogramaTurma> recuperaCronogramaTurma(Long idTurma) throws PlcException;

	/**
	 * @param login
	 * @return
	 */
	UsuarioEntity recuperaUsuarioByLogin(String login) throws PlcException;

	/**
	 * Recupera o funcinario pelo id
	 * @param id
	 * @return
	 */
	FuncionarioEntity recuperaFuncionarioById(Long id) throws PlcException;

	/**
	 * UTilizado para montar o detalhe e sub-detalhe do registro de notas, recuperando as turmas e alunos do professor para a disciplina
	 * @param registro
	 * @throws PlcException 
	 */
	void montaDetalheSubDetalhe(RegistroNotasFundamentalEntity registro) throws PlcException;
	
	/**
	 * Utilizado para recuperar a descri�ao da turma pelo id
	 * @param idTurma
	 * @return
	 * @throws PlcException
	 */
	String recuperaDescricaoTurma(Long idTurma) throws PlcException;

	/**
	 * Utilizado para montar o grafo do boletim fundamental quando for um novo registro.
	 * Recuperando todas informa�oes pelo id do aluno
	 * @param idAluno
	 * @param appBaseContextVO 
	 * @throws PlcException 
	 */
	PlcBaseVO montaBoletimAluno( Long idAluno, BoletimFundamentalEntity boletim, AppBaseContextVO appBaseContextVO ) throws PlcException;

	/**
	 * Utilizado para setar o registro de notas como Aberto quando for reprovado pela diretoria.
	 * @param listBoletimDetReprovar
	 */
	void reprovaRegistroNotas(List<BoletimFundamentalDetEntity> listBoletimDetReprovar) throws PlcException;

	Long temContratoVigente(Long idAluno, int year) throws PlcException;

	byte[] recuperaContratoAluno(Long idContrato) throws PlcException;

	boolean validaTabelaDuplicada(Long idTurma, Long idTabela) throws PlcException;
	
	/**
	 * Recupera o valor da mensalidade pela turma e carga horaria
	 * @param idTurma
	 * @param cargaHoraria
	 * @return
	 * @throws PlcException 
	 * @throws PlcException
	 */
	BigDecimal recuperaValorMensalidade( Long idTurma, String cargaHoraria ) throws PlcException;
	
	/**
	 * Recupera a idade maxima e minima permitida
	 * para o aluno entrar na turma
	 * @param idTipoEducacao
	 * @return Long idade
	 * @throws PlcException
	 */
	TurmaEntity recuperaIdadePermitida( Long idTurma ) throws PlcException;

	FornecedorEntity recuperaCpf(String cpf) throws PlcException;

	FornecedorEntity recuperaCnpj(String cnpj) throws PlcException;

	/**
	 * Recupera a lista de Tipo Plano Contas pelo id do Plano Contas
	 * @param idPlanoConta
	 * @return List
	 * @throws PlcException
	 */
	ArrayList<TipoPlanoContasEntity> recuperaListaTipoPlanoContaByIdPlanoConta(Long idPlanoConta) throws PlcException;
	
	/**
	 * @param contaReceber
	 */
	Boleto gerarBoleta(ContaReceberEntity contaReceber) throws PlcException;

	/**
	 * Utilizado para somar e retornar o valor de todos os servi�os do aluno
	 * @param listServicoAluno
	 * @return
	 * @throws PlcException
	 */
	BigDecimal getValorTotalServicosAluno( List<ServicoAluno> listServicoAluno ) throws PlcException;

	AlunoEntity recuperarAlunoVO( Long idAluno ) throws PlcException;
	
	/**
	 *Faz update no contrato
	 * @param contrato
	 * @throws PlcException
	 */
	void alteraContrato( ContratoEntity contrato ) throws PlcException;
	
	/**
	 * Recupera o endereco do aluno
	 * @param idAluno
	 * @return
	 * @throws PlcException
	 */
	EnderecoEntity recuperaEnderecoAluno( Long idAluno ) throws PlcException;
	
	/**
	 * Recupera o responsavel financeiro do aluno
	 * @param idAluno
	 * @return
	 * @throws PlcException
	 */
	ResponsavelFinanceiroAlunoEntity recuperaResponsavelFinanceiroAluno( Long idAluno ) throws PlcException;

	List<ContaPagar> recuperaContaPagarByExtrato(Date dataInicio, Date dataFim) throws PlcException;

	List<ContaReceber> recuperaContaReceberByExtrato(Date dataInicio, Date dataFim) throws PlcException;
	
	/**
	 * Utilizado para gravar o contas a reber por demanda
	 * @param listaVO
	 * @throws PlcException
	 */
	void gravarContaReceberPorDemanda( List<PlcBaseVO> listaVO) throws PlcException;

	/**
	 * Recupera os bancos cadastrados
	 * @return List Banco
	 * @throws PlcException 
	 */
	List<BancoEntity> recuperaListaBanco() throws PlcException;

	void excluirServicoAluno(Long id) throws PlcException;
	
	AlunoEntity recuperarAlunoVOByServico( Long idAluno ) throws PlcException;
}

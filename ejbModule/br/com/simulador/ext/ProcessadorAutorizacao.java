package br.com.simulador.ext;

import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;

import br.com.simulador.client.ITransacao;
import br.com.simulador.entidades.CasoDeTeste;
import br.com.simulador.entidades.Configuracao;
import br.com.simulador.entidades.TipoTransacao;
import br.com.simulador.entidades.Transacao;
import br.com.simulador.persistencia.DAOTipoTransacao;


public class ProcessadorAutorizacao implements IProcessador{
	EntityManager em;
	public ProcessadorAutorizacao(ITransacao trx, EntityManager em) {
		System.out.println("Processador criado..."+ trx.getClass().getName());
		this.em = em;
		// TODO Auto-generated constructor stub
	}
	/*
	 * 1- Selecionar a transação 0100 ou 0200 na tabela de transação.
	 * 2- submeter transação  
	 * */
	@Override
	public void processar() {
		try {
			
			TipoTransacao tipo = new TipoTransacao();
			tipo.setCodProcessamento("003000");
			tipo.setMti("0100");
			tipo.setTipoTransacao("Compra Credito");	
			//tipo.setTransacoes(transacoes);
			DAOTipoTransacao t = new DAOTipoTransacao(em);
			t.gravar(tipo);
		} catch (Exception e) {
			System.out.println("Erro em " + this.getClass().getName()+". Motivo:"+e.getMessage());
		}
	}

	/*
	private Transacao selectTransacao(long codigo) {
		return dao.selecionar(codigo);
	}
	*/
	
}

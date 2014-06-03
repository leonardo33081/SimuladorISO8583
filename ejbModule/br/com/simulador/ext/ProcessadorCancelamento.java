package br.com.simulador.ext;

import javax.persistence.EntityManager;

import br.com.simulador.client.ITransacao;
import br.com.simulador.persistencia.DAOTransacao;

public class ProcessadorCancelamento implements IProcessador{
	EntityManager em;
	public ProcessadorCancelamento(ITransacao trx, EntityManager em) {
		System.out.println("Processador criado..." + trx.getClass().getName());
		this.em = em;
	}

	@Override
	public void processar() {
		System.out.println("Processando...");
		DAOTransacao dao = new DAOTransacao(em);
	}
}

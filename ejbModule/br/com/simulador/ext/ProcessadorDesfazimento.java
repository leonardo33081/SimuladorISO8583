package br.com.simulador.ext;

import javax.persistence.EntityManager;

import br.com.simulador.client.ITransacao;
import br.com.simulador.persistencia.DAOTransacao;

public class ProcessadorDesfazimento implements IProcessador{
	EntityManager em;
	public ProcessadorDesfazimento(ITransacao trx, EntityManager em) {
		System.out.println("Processador criado..." + trx.getClass().getName());
		this.em = em;
	}

	@Override
	public void processar() {
		DAOTransacao dao = new DAOTransacao(em);
		
	}
}

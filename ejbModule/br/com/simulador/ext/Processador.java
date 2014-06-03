package br.com.simulador.ext;

import javax.persistence.EntityManager;

import br.com.simulador.client.AutorizacaoRemote;
import br.com.simulador.client.CancelamentoRemote;
import br.com.simulador.client.ConfirmacaoRemote;
import br.com.simulador.client.DesfazimentoRemote;
import br.com.simulador.client.ITransacao;
import br.com.simulador.exception.NotSupportedTransactionException;

public class Processador {
	ITransacao trx;
	public Processador (ITransacao trx){
		this.trx = trx;
	}

	public IProcessador getInstance(EntityManager em) throws NotSupportedTransactionException{
		if(this.trx instanceof AutorizacaoRemote)
			return new ProcessadorAutorizacao(this.trx,em);
		
		if(this.trx instanceof CancelamentoRemote)
			return new ProcessadorCancelamento(this.trx,em);
		
		if(this.trx instanceof ConfirmacaoRemote)
			return new ProcessadorConfirmacao(this.trx,em);
		
		if(this.trx instanceof DesfazimentoRemote)
			return new ProcessadorDesfazimento(this.trx,em);
		
		throw new NotSupportedTransactionException("Interface " + trx.getClass().getName() + " não suportada em " + this.getClass().getName());
	}
}

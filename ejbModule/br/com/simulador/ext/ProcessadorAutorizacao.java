package br.com.simulador.ext;

import org.jpos.iso.ISOMsg;

import br.com.simulador.bean.AutorizacaoBean;
import br.com.simulador.persistencia.EManager;

public class ProcessadorAutorizacao {

	public ProcessadorAutorizacao(AutorizacaoBean a){
		ISOMsg iso = new ISOMsg();
		System.out.println("Processador criado..."+a.getClass().getName());
		//EManager.createEntityManager();
	}
}

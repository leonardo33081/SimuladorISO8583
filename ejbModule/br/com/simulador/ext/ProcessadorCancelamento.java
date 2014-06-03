package br.com.simulador.ext;

import org.jpos.iso.ISOMsg;

import br.com.simulador.bean.CancelamentoBean;

public class ProcessadorCancelamento {

	public ProcessadorCancelamento(CancelamentoBean c){
		ISOMsg iso = new ISOMsg();
		System.out.println("Processador criado..." + c.getClass().getName());
	}
}

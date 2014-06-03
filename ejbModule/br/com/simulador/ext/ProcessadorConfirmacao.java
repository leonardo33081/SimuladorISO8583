package br.com.simulador.ext;

import org.jpos.iso.ISOMsg;

import br.com.simulador.bean.ConfirmacaoBean;

public class ProcessadorConfirmacao {

	public ProcessadorConfirmacao(ConfirmacaoBean c){
		ISOMsg iso = new ISOMsg();
		System.out.println("Processador criado..." + c.getClass().getName());
	}
}

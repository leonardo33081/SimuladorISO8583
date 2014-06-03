package br.com.simulador.ext;

import org.jpos.iso.ISOMsg;

import br.com.simulador.bean.DesfazimentoBean;

public class ProcessadorDesfazimento {

	public ProcessadorDesfazimento(DesfazimentoBean d){
		ISOMsg iso = new ISOMsg();
		System.out.println("Processador criado..." + d.getClass().getName());
	}
}

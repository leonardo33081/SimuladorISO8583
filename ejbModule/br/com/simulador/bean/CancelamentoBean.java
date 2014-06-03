package br.com.simulador.bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.simulador.client.CancelamentoRemote;
import br.com.simulador.entidades.Transacao;
import br.com.simulador.ext.ProcessadorAutorizacao;
import br.com.simulador.ext.ProcessadorCancelamento;
@Stateless
@Remote(CancelamentoRemote.class)
public class CancelamentoBean implements CancelamentoRemote {

	
	ProcessadorCancelamento procCancel;
	@PostConstruct
	private void initProcessadorCancelamento(){
		System.out.println("Contruindo processador de cancelamento...");
		procCancel = new ProcessadorCancelamento(this);
	}
	public boolean cancelar() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getTransação() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

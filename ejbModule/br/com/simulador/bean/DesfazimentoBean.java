package br.com.simulador.bean;

import java.util.Map;

import javax.ejb.PostActivate;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.simulador.client.DesfazimentoRemote;
import br.com.simulador.entidades.Transacao;
import br.com.simulador.ext.ProcessadorConfirmacao;
import br.com.simulador.ext.ProcessadorDesfazimento;
@Stateless
@Remote(DesfazimentoRemote.class)
public class DesfazimentoBean implements DesfazimentoRemote {

	ProcessadorDesfazimento procDesfazimento;
	@PostActivate
	private void initProcessadorDesfazimento(){
		System.out.println("Contruindo processador de desfazimento...");
		procDesfazimento = new ProcessadorDesfazimento(this);
	}
	
	public boolean desfazer() {
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

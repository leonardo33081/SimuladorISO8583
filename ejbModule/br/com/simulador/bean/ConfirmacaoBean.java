package br.com.simulador.bean;

import java.util.Map;

import javax.ejb.PostActivate;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.simulador.client.ConfirmacaoRemote;
import br.com.simulador.entidades.Transacao;
import br.com.simulador.ext.ProcessadorConfirmacao;
@Stateless
@Remote(ConfirmacaoRemote.class)
public class ConfirmacaoBean implements ConfirmacaoRemote {
	ProcessadorConfirmacao procConfirmacao;
	@PostActivate
	private void initProcessadorConfirmacao(){
		System.out.println("Contruindo processador de confirmação...");
		procConfirmacao = new ProcessadorConfirmacao(this);
	}

	public boolean confirmar() {
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

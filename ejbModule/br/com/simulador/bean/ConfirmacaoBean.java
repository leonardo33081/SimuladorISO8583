package br.com.simulador.bean;

import java.util.Map;

import javax.ejb.PostActivate;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.client.ConfirmacaoRemote;
import br.com.simulador.exception.NotSupportedTransactionException;
import br.com.simulador.ext.IProcessador;
import br.com.simulador.ext.Processador;
@Stateless
@Remote(ConfirmacaoRemote.class)
public class ConfirmacaoBean implements ConfirmacaoRemote {
	@PersistenceContext(unitName="persistenciaISO")
    private EntityManager em;
	IProcessador proc;
	@PostActivate
	private void initProcessadorConfirmacao(){
		System.out.println("Contruindo processador de confirmação...");
		try {
			proc = new Processador(this).getInstance(em);
		} catch (NotSupportedTransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean confirmar() {
		proc.processar();
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

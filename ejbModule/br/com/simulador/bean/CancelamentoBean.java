package br.com.simulador.bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.client.CancelamentoRemote;
import br.com.simulador.exception.NotSupportedTransactionException;
import br.com.simulador.ext.IProcessador;
import br.com.simulador.ext.Processador;
@Stateless
@Remote(CancelamentoRemote.class)
public class CancelamentoBean implements CancelamentoRemote {
	@PersistenceContext(unitName="persistenciaISO")
    private EntityManager em;
	IProcessador proc;
	@PostConstruct
	private void initProcessador(){
		System.out.println("Contruindo processador de cancelamento...");
		try {
			proc = new Processador(this).getInstance(em);
		} catch (NotSupportedTransactionException e) {
			e.printStackTrace();
		}
	}
	public boolean cancelar() {
		// usar o proc
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

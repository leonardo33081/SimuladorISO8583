package br.com.simulador.bean;

import java.util.Map;

import javax.ejb.PostActivate;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.client.DesfazimentoRemote;
import br.com.simulador.exception.NotSupportedTransactionException;
import br.com.simulador.ext.IProcessador;
import br.com.simulador.ext.Processador;
@Stateless
@Remote(DesfazimentoRemote.class)
public class DesfazimentoBean implements DesfazimentoRemote {
	@PersistenceContext(unitName="persistenciaISO")
    private EntityManager em;
	IProcessador proc;
	@PostActivate
	private void initProcessadorDesfazimento(){
		System.out.println("Contruindo processador de desfazimento...");
		try {
			proc = new Processador(this).getInstance(em);
		} catch (NotSupportedTransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean desfazer() {
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

package br.com.simulador.bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.client.AutorizacaoRemote;
import br.com.simulador.exception.NotSupportedTransactionException;
import br.com.simulador.ext.IProcessador;
import br.com.simulador.ext.Processador;
import br.com.simulador.persistencia.DAOTransacao;

@Stateless
@Remote(AutorizacaoRemote.class)
public class AutorizacaoBean implements AutorizacaoRemote {
	IProcessador proc;
	boolean flag= true;
	//
	@EJB 
	DAOTransacao dao;
	//
	@PersistenceContext(unitName="persistenciaISO")    
	private EntityManager em;
	//
	@PostConstruct
	private void initProcessador(){
		try {
			System.out.println("Contruindo processador de autorização...");
			proc = new Processador(this).getInstance(em);
		} catch (NotSupportedTransactionException e) {
			e.printStackTrace();
		}
	}
	
	public boolean autorizar() {
		/*
		 * 1- Selecionar a transação 0100 ou 0200 na tabela de transação.
		 * 2- submeter transação  
		 * */
	
		if(em==null)
			System.out.println("EM Nulo");
		else
			System.out.println("EM ok");
		proc.processar();
		
		return true;
	}


	public String getLog() {
		// TODO Auto-generated method stub
		return null;
	}
	//devolve in/out
	public Map<String, String> getTransação() {
		// TODO Auto-generated method stub
		return null;
	}

}

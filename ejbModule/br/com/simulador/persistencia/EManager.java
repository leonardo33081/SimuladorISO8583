package br.com.simulador.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EManager {

	public static EntityManager createEntityManager(){
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenciaISO");
			return factory.createEntityManager();
		} catch (Exception e) {
			return null;
		}
	} 
}

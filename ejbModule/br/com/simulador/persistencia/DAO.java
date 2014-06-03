package br.com.simulador.persistencia;

import javax.persistence.EntityManager;

public class DAO<T> {

    private EntityManager em;
    private Class<T> classe;

    public DAO(EntityManager em, Class<T> classe){
    	this.em = em;
    	this.classe = classe;
    	if(em == null)
    		System.out.println("Entity manager está nulo!");
    }
    public boolean gravar(T t){
    	System.out.println("T="+t.toString());
    	this.em.persist(t);
    	return true;
    }
    
    public Object selecionar(Integer codigo){
    	return this.em.getReference(classe, codigo);
    }
    public boolean remover(T t){
    	this.em.remove(t);
    	return true;
    }
}

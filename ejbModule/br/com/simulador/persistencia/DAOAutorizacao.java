package br.com.simulador.persistencia;

import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.Transacao;

/**
 * Session Bean implementation class DAOAutorizacao
 */
@Stateless
public class DAOAutorizacao {

	@PostActivate
	private void init(){
		System.out.println("Inicializando DAO " + this.getClass().getName());
	}
    /**
     * Default constructor. 
     */
    public DAOAutorizacao() {
       System.out.println("Iniciando o " + this.getClass().getName());
    }
    @PersistenceContext(unitName="persistenciaISO")
    private EntityManager em;
 
    public boolean gravar(Transacao trx){
        boolean sucesso = false;
        try {
        	em.merge(trx);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public Transacao selecionar(Long codigo){
        Transacao trx = null;
        try {
            trx = em.find(Transacao.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return trx;
    }
 
    public boolean remover(Transacao trx){
        boolean sucesso = false;
        try {
            trx = em.find(Transacao.class, trx.getIdtransacao());
            em.remove(trx);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    
}

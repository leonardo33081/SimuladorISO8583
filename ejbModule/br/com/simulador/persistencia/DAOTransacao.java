package br.com.simulador.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.CasoDeTeste;
import br.com.simulador.entidades.Transacao;

/**
 * Session Bean implementation class DAOAutorizacao
 */
@Stateless
public class DAOTransacao {

	/**
     * Default constructor. 
     */
	private DAO<Transacao> dao;
	EntityManager em;
	public DAOTransacao() {	}
	public DAOTransacao(EntityManager em) {
		this.em = em;
		dao = new DAO<Transacao>(em, Transacao.class);
       
    }
 
    public boolean gravar(Transacao trx){
        boolean sucesso = false;
        try {
        	dao.gravar(trx);
        	sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public Transacao selecionar(Integer codigo){
        Transacao trx = null;
        try {
            trx = (Transacao) dao.selecionar(codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return trx;
    }
 
    public boolean remover(Transacao trx){
        boolean sucesso = false;
        try {
        	sucesso = dao.remover(trx);
            dao.remover(trx);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public void createDAO(EntityManager emm){
    	this.em = emm;
    	if(dao == null)
    		dao = new DAO<Transacao>(em, Transacao.class);
    }
}

package br.com.simulador.persistencia;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.TipoTransacao;

/**
 * Session Bean implementation class DAOAutorizacao
 */
@Stateless
public class DAOTipoTransacao {
	@PostConstruct
	private void init(){
		System.out.println("Inicializando DAO " + this.getClass().getName());
	}
    /**
     * Default constructor. 
     */
	private EntityManager em;
	private DAO<TipoTransacao> dao;
	public DAOTipoTransacao() {}
	public DAOTipoTransacao(EntityManager em) {
		this.em = em;
		dao = new DAO<TipoTransacao>(em, TipoTransacao.class);
    }
 
    public boolean gravar(TipoTransacao trx){
        boolean sucesso = false;
        try {
        	System.out.println("Gravando:" + trx.toString());
        	dao.gravar(trx);
        	sucesso = true;
        } catch (Exception e) {
            System.out.println("Nao foi possivel gravar o dado. Motivo:"+e.getCause());
        }
        return sucesso;
    }
 
    public TipoTransacao selecionar(Integer codigo){
    	TipoTransacao trx = null;
        try {
            trx = (TipoTransacao) dao.selecionar(codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return trx;
    }
 
    public boolean remover(TipoTransacao trx){
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
    		dao = new DAO<TipoTransacao>(em, TipoTransacao.class);
    }
    
}

package br.com.simulador.persistencia;

import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.com.simulador.entidades.CasoDeTeste;
/**
 * Session Bean implementation class DAOCasoDeTeste
 */
@Stateless
public class DAOCasoDeTeste {

	EntityManager em;
	private DAO<CasoDeTeste> dao;
	public DAOCasoDeTeste(){}
	public DAOCasoDeTeste(EntityManager em){
		this.em = em;
		dao = new DAO<CasoDeTeste>(em, CasoDeTeste.class);
	}
	@PostActivate
	private void init(){
		System.out.println("Inicializando DAO " + this.getClass().getName());
	}
    /**
     * Default constructor. 
     */
    public boolean gravar(CasoDeTeste ct){
        boolean sucesso = false;
        try {
        	dao.gravar(ct);
            sucesso = true;
        } catch (Exception e) {
            System.out.println("Erro ao gravar caso de teste. Motivo:"+ e.getMessage());
        }
 
        return sucesso;
    }
 
    public CasoDeTeste selecionar(Integer codigo){
        CasoDeTeste ct = null;
        try {
            ct = (CasoDeTeste) dao.selecionar(codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return ct;
    }
 
    public boolean remover(CasoDeTeste ct){
        boolean sucesso = false;
        try {
            sucesso = dao.remover(ct);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public void createDAO(EntityManager emm){
    	this.em = emm;
    	if(dao == null)
    		dao = new DAO<CasoDeTeste>(em, CasoDeTeste.class);
    }
    
}

package br.com.simulador.persistencia;

import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.entidades.CasoDeTeste;
import br.com.simulador.entidades.Configuracao;
import br.com.simulador.entidades.Transacao;
/**
 * Session Bean implementation class DAOConfiguracao
 */
@Stateless
public class DAOConfiguracao {
	private DAO<Configuracao> dao;
	EntityManager em;
	public  DAOConfiguracao(){}
	public  DAOConfiguracao(EntityManager em){
		this.em = em;
		dao = new DAO<Configuracao>(em, Configuracao.class);
	}
	
	@PostActivate
	private void init(){
		System.out.println("Inicializando DAO " + this.getClass().getName());
	}
 
	public boolean gravar(Configuracao c){
        boolean sucesso = false;
        try {
        	System.out.println("Gravando:" + c.toString());
        	dao.gravar(c);
            sucesso = true;
        } catch (Exception e) {
        	System.out.println("Nao foi possivel gravar o dado. Motivo:"+e.getCause());
        }
 
        return sucesso;
    }
 
    public Configuracao selecionar(Integer codigo){
        Configuracao c = null;
        try {
            c = (Configuracao) dao.selecionar(codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return c;
    }
 
    public boolean remover(Configuracao c){
        boolean sucesso = false;
        try {
        	sucesso = dao.remover(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
    public void createDAO(EntityManager emm){
    	this.em = emm;
    	if(dao == null)
    		dao = new DAO<Configuracao>(em, Configuracao.class);
    }
}

package br.com.simulador.bean;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.simulador.client.AutorizacaoRemote;
import br.com.simulador.entidades.CasoDeTeste;
import br.com.simulador.entidades.Configuracao;
import br.com.simulador.entidades.Transacao;
import br.com.simulador.ext.ProcessadorAutorizacao;
import br.com.simulador.persistencia.DAOAutorizacao;

@Stateless
@Remote(AutorizacaoRemote.class)
public class AutorizacaoBean implements AutorizacaoRemote {

	@EJB
	DAOAutorizacao dao;
	boolean flag= true;
	ProcessadorAutorizacao procAuto;
	@PostConstruct
	private void initProcessadorAutorizacao(){
		System.out.println("Contruindo processador de autorização...");
		procAuto = new ProcessadorAutorizacao(this);
		if(dao == null)
			System.out.println("Dao está nulo");
		else{
			System.out.println("Dao disponivel. Dao=" + dao.toString());
			flag = false;
		}
	}
	public boolean autorizar() {
		if(flag)
			System.out.println("Indisponivel");
		else{
			System.out.println("Disponivel");
			Transacao t = null; t = getTransacao(t); 
			Set<Transacao> st = new TreeSet<Transacao>();
			st.add(t);
			
			Configuracao con=null; con = getConfiguracao(con); 
			CasoDeTeste c=null; c = getCasoTeste(c,con, st); 
			
			t.setCasoDeTeste(null);
			dao.gravar(t);
			
		}
		return true;
	}

	private Configuracao getConfiguracao(Configuracao con) {
		if(con == null)
			con = new Configuracao();
		con.setTimeout(12000);
		con.setPorta("1500");
		con.setPath("lklklçkj");
		con.setPackager("GenericPackager");
		con.setIdconfiguracao(2);
		con.setHost("192.168.50.162");
		con.setDescConfig("Primeira configuracao");
		con.setChannel("PADChannel");
		return con;
	}
	private CasoDeTeste getCasoTeste(CasoDeTeste c, Configuracao conf, Set<Transacao> t) {
		if(c==null)
			c = new CasoDeTeste();
		
		c.setCasoDeTestecol("aaa");
		c.setConfiguracao(conf);
		c.setDescricao("teste");
		c.setDtInclusao(new Date());
		c.setIdcasoDeTeste(10);
		c.setNome("Primeiro caso de teste");
		c.setTransacaos(t);
		return c;
	}
	private Transacao getTransacao(Transacao t) {
		if(t==null)
			t = new Transacao();
		
		t.setDifTempoInOut(12);
		t.setDtInclusao(new Date());
		t.setIdtransacao(3);
		t.setMsgIsoIn("in");
		t.setMsgIsoOut("out");
		
		return t;
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

	public static void main(String[] args) {
		new AutorizacaoBean().autorizar();
	
	}

}

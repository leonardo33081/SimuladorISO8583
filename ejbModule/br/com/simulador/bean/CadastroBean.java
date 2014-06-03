package br.com.simulador.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.simulador.client.Cadastro;
import br.com.simulador.entidades.CasoDeTeste;
import br.com.simulador.entidades.Configuracao;
import br.com.simulador.entidades.TipoTransacao;
import br.com.simulador.entidades.Transacao;
import br.com.simulador.persistencia.DAOCasoDeTeste;
import br.com.simulador.persistencia.DAOConfiguracao;
import br.com.simulador.persistencia.DAOTipoTransacao;
import br.com.simulador.persistencia.DAOTransacao;
@Stateless
@Remote(Cadastro.class)
public class CadastroBean implements Cadastro {

	@PersistenceContext
	EntityManager em;
	@EJB
	DAOCasoDeTeste cteste;
	@EJB
	DAOTipoTransacao tipoTrx;
	@EJB
	DAOTransacao transacao;
	@EJB
	DAOConfiguracao configuracao;
	@Override
	public boolean cadastrar(Serializable obj) {
		try{
			cteste.createDAO(em);
			tipoTrx.createDAO(em);
			transacao.createDAO(em);
			configuracao.createDAO(em);
			CasoDeTeste ct = new CasoDeTeste();
			Configuracao c = new Configuracao();
			TipoTransacao tipo = new TipoTransacao();
			Transacao trx = new Transacao();

			//Tipo de transação
			tipo.setCodProcessamento("002000");
			tipo.setMti("0200");
			tipo.setTipoTransacao("Compra Debito");
			
			
			tipoTrx.gravar(tipo);
			//transacao
			trx.setDifTempoInOut(20000);
			trx.setDtInclusao(new Date());
			trx.setMsgIsoIn("02003453454654346546546546465465sdafsdafad5465465sadf65d4s654sdafg4sd5g46sd54gd");
			trx.setMsgIsoOut("021000003213212143514313213213032135465465545645222222222");
			trx.setTipoTransacao(tipo);
			trx.setCasoDeTeste(ct);
			transacao.gravar(trx);
			//caso de teste
			ct.setDescricao("ct 1");
			ct.setDtInclusao(new Date());
			ct.setNome("ct teste");
			Set<Transacao> s = new TreeSet<Transacao>();s.add(trx);
			ct.setTransacaos(s);
			
			cteste.gravar(ct);
			//configuracao
			c.setCasoDeTeste(ct.getIdcasoDeTeste());
			c.setChannel("okokok");
			c.setHost("localhost");
			c.setPorta("5666");
			c.setTimeout(20000);
			c.setConfiguracao("Homologação");
		
			configuracao.gravar(c);

		}catch(Exception e){
			System.out.println("Erro em cadastrobean. Motivo:"+e.getMessage());
		}
		return true;
	}

	@Override
	public boolean excluir(Serializable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Serializable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selecionar(Serializable obj) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

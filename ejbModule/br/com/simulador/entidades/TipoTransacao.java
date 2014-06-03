package br.com.simulador.entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the tipo_transacao database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="TipoTransacao.findAll", query="SELECT tt FROM TipoTransacao tt")
})
public class TipoTransacao implements Serializable {
	private static final long serialVersionUID = 1L;

	public TipoTransacao() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtipo_transacao")
	private int idtipoTransacao;
	
	@Column(name="tipo_transacao")
	private String tipoTransacao;
	
	@Column(name="cod_processamento")
	private String codProcessamento;

	@Column(name="mti")
	private String mti;

	//bi-directional many-to-one association to CasoDeTeste
	@OneToMany(mappedBy="tipoTransacao")
	private Set<Transacao> transacoes;
	
	
	public Set<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(Set<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public int getIdtipoTransacao() {
		return idtipoTransacao;
	}

	public void setIdtipoTransacao(int idtipoTransacao) {
		this.idtipoTransacao = idtipoTransacao;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public String getCodProcessamento() {
		return codProcessamento;
	}

	public void setCodProcessamento(String codProcessamento) {
		this.codProcessamento = codProcessamento;
	}

	public String getMti() {
		return mti;
	}

	public void setMti(String mti) {
		this.mti = mti;
	}

	@Override
	public String toString() {
		return "TipoTransacao [idtipoTransacao=" + idtipoTransacao
				+ ", tipoTransacao=" + tipoTransacao + ", codProcessamento="
				+ codProcessamento + ", mti=" + mti + ", transacoes="
				+ transacoes + "]";
	}



	
}
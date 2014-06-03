package br.com.simulador.entidades;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transacao database table.
 * 
 */
@Entity

@Table(name = "transacao")
@NamedQueries({
	@NamedQuery(name="Transacao.findAll", query="SELECT t FROM Transacao t")
})
public class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtransacao;

	@Column(name="dif_tempo_in_out")
	private int difTempoInOut;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inclusao")
	private Date dtInclusao;

	@Column(name="msg_iso_in")
	private String msgIsoIn;

	@Column(name="msg_iso_out")
	private String msgIsoOut;

	//bi-directional many-to-one association to CasoDeTeste
	@ManyToOne
	@JoinColumn(name="idcaso_de_teste")
	private CasoDeTeste casoDeTeste;
	
	@ManyToOne
	@JoinColumn(name="idtipo_transacao")
	private TipoTransacao tipoTransacao;
	
	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Transacao() {
	}

	public int getIdtransacao() {
		return this.idtransacao;
	}

	public void setIdtransacao(int idtransacao) {
		this.idtransacao = idtransacao;
	}

	public int getDifTempoInOut() {
		return this.difTempoInOut;
	}

	public void setDifTempoInOut(int difTempoInOut) {
		this.difTempoInOut = difTempoInOut;
	}

	public Date getDtInclusao() {
		return this.dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public String getMsgIsoIn() {
		return this.msgIsoIn;
	}

	public void setMsgIsoIn(String msgIsoIn) {
		this.msgIsoIn = msgIsoIn;
	}

	public String getMsgIsoOut() {
		return this.msgIsoOut;
	}

	public void setMsgIsoOut(String msgIsoOut) {
		this.msgIsoOut = msgIsoOut;
	}

	public CasoDeTeste getCasoDeTeste() {
		return this.casoDeTeste;
	}

	public void setCasoDeTeste(CasoDeTeste casoDeTeste) {
		this.casoDeTeste = casoDeTeste;
	}

	@Override
	public String toString() {
		return "Transacao [idtransacao=" + idtransacao + ", difTempoInOut="
				+ difTempoInOut + ", dtInclusao=" + dtInclusao + ", msgIsoIn="
				+ msgIsoIn + ", msgIsoOut=" + msgIsoOut + ", casoDeTeste="
				+ casoDeTeste + ", tipoTransacao=" + tipoTransacao + "]";
	}

}
package br.com.simulador.entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the caso_de_teste database table.
 * 
 */
@Entity
@Table(name="caso_de_teste")
@NamedQuery(name="CasoDeTeste.findAll", query="SELECT c FROM CasoDeTeste c")
public class CasoDeTeste implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idcaso_de_teste")
	private int idcasoDeTeste;

	@Column(name="caso_de_testecol")
	private String casoDeTestecol;

	private String descricao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inclusao")
	private Date dtInclusao;

	private String nome;

	//bi-directional many-to-one association to Configuracao
	@ManyToOne
	@JoinColumn(name="fkconfiguracao")
	private Configuracao configuracao;

	//bi-directional many-to-one association to Transacao
	@OneToMany(mappedBy="casoDeTeste", fetch=FetchType.EAGER)
	private Set<Transacao> transacaos;

	public CasoDeTeste() {
	}

	public int getIdcasoDeTeste() {
		return this.idcasoDeTeste;
	}

	public void setIdcasoDeTeste(int idcasoDeTeste) {
		this.idcasoDeTeste = idcasoDeTeste;
	}

	public String getCasoDeTestecol() {
		return this.casoDeTestecol;
	}

	public void setCasoDeTestecol(String casoDeTestecol) {
		this.casoDeTestecol = casoDeTestecol;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtInclusao() {
		return this.dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Configuracao getConfiguracao() {
		return this.configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public Set<Transacao> getTransacaos() {
		return this.transacaos;
	}

	public void setTransacaos(Set<Transacao> transacaos) {
		this.transacaos = transacaos;
	}

	public Transacao addTransacao(Transacao transacao) {
		getTransacaos().add(transacao);
		transacao.setCasoDeTeste(this);

		return transacao;
	}

	public Transacao removeTransacao(Transacao transacao) {
		getTransacaos().remove(transacao);
		transacao.setCasoDeTeste(null);

		return transacao;
	}

}
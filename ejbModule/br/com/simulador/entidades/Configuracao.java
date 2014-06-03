package br.com.simulador.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the configuracao database table.
 * 
 */
@Entity
@NamedQuery(name="Configuracao.findAll", query="SELECT c FROM Configuracao c")
public class Configuracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idconfiguracao;

	@Column(name="caso_de_teste")
	private int casoDeTeste;

	private String channel;

	private String configuracao;

	@Column(name="desc_config")
	private String descConfig;

	private String host;

	private String packager;

	private String path;

	private String porta;

	private int timeout;

	//bi-directional many-to-one association to CasoDeTeste
	@OneToMany(mappedBy="configuracao", fetch=FetchType.EAGER)
	private List<CasoDeTeste> casoDeTestes;

	public Configuracao() {
	}

	public int getIdconfiguracao() {
		return this.idconfiguracao;
	}

	public void setIdconfiguracao(int idconfiguracao) {
		this.idconfiguracao = idconfiguracao;
	}

	public int getCasoDeTeste() {
		return this.casoDeTeste;
	}

	public void setCasoDeTeste(int casoDeTeste) {
		this.casoDeTeste = casoDeTeste;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getConfiguracao() {
		return this.configuracao;
	}

	public void setConfiguracao(String configuracao) {
		this.configuracao = configuracao;
	}

	public String getDescConfig() {
		return this.descConfig;
	}

	public void setDescConfig(String descConfig) {
		this.descConfig = descConfig;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPackager() {
		return this.packager;
	}

	public void setPackager(String packager) {
		this.packager = packager;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPorta() {
		return this.porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public int getTimeout() {
		return this.timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public List<CasoDeTeste> getCasoDeTestes() {
		return this.casoDeTestes;
	}

	public void setCasoDeTestes(List<CasoDeTeste> casoDeTestes) {
		this.casoDeTestes = casoDeTestes;
	}

	public CasoDeTeste addCasoDeTeste(CasoDeTeste casoDeTeste) {
		getCasoDeTestes().add(casoDeTeste);
		casoDeTeste.setConfiguracao(this);

		return casoDeTeste;
	}

	@Override
	public String toString() {
		return "Configuracao [idconfiguracao=" + idconfiguracao
				+ ", casoDeTeste=" + casoDeTeste + ", channel=" + channel
				+ ", configuracao=" + configuracao + ", descConfig="
				+ descConfig + ", host=" + host + ", packager=" + packager
				+ ", path=" + path + ", porta=" + porta + ", timeout="
				+ timeout + ", casoDeTestes=" + casoDeTestes + "]";
	}

	public CasoDeTeste removeCasoDeTeste(CasoDeTeste casoDeTeste) {
		getCasoDeTestes().remove(casoDeTeste);
		casoDeTeste.setConfiguracao(null);

		return casoDeTeste;
	}

}
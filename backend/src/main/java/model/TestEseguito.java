package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class TestEseguito {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="NOMETEST", type=ColumnType.STRING, isNullable=false)
	private String nometest;
	@Column(name="IMBARCAZIONE", type=ColumnType.STRING, isNullable=false)
	private String imbarcazione;
	@Column(name="TECNICO", type=ColumnType.STRING, isNullable=false)
	private String tecnico;
	@Column(name="DATADIESECUZIONE", type=ColumnType.STRING, isNullable=false)
	private String datadiesecuzione;
	@Column(name="PUNTEGGIO", type=ColumnType.STRING, isNullable=false)
	private String punteggio;
	public String getNometest() {
		return nometest;
	}
	public void setNometest(String nometest) {
		this.nometest = nometest;
	}
	public String getImbarcazione() {
		return imbarcazione;
	}
	public void setImbarcazione(String imbarcazione) {
		this.imbarcazione = imbarcazione;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public String getDatadiesecuzione() {
		return datadiesecuzione;
	}
	public void setDatadiesecuzione(String datadiesecuzione) {
		this.datadiesecuzione = datadiesecuzione;
	}
	public String getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(String punteggio) {
		this.punteggio = punteggio;
	}

}

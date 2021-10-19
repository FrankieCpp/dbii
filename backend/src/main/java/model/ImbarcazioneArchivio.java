package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class ImbarcazioneArchivio {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="matricola", type=ColumnType.STRING, isNullable=false)
	private String matricola;
	@Column(name="socio", type=ColumnType.STRING, isNullable=false)
	private String socio;
	@Column(name="modello", type=ColumnType.STRING, isNullable=false)
	private String modello;

	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getSocio() {
		return socio;
	}
	public void setSocio(String socio) {
		this.socio = socio;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
}

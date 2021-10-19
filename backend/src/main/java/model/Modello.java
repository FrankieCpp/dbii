package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Modello {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="codice", type=ColumnType.STRING, isNullable=false)
	private String codice;
	@Column(name="stazza", type=ColumnType.INT, isNullable=false)
	private int stazza;
	@Column(name="lunghezza", type=ColumnType.INT, isNullable=false)
	private int lunghezza;
	@Column(name="pescaggio", type=ColumnType.INT, isNullable=false)
	private int pescaggio;

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getStazza() {
		return stazza;
	}
	public void setStazza(int stazza) {
		this.stazza = stazza;
	}
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	public int getPescaggio() {
		return pescaggio;
	}
	public void setPescaggio(int pescaggio) {
		this.pescaggio = pescaggio;
	}

}

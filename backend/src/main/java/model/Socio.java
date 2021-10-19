package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Socio {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="codiceFiscale", type=ColumnType.STRING, isNullable=false)
	private String codiceFiscale;

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
}

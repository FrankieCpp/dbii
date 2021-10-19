package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class ComandabileDa {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="capitano", type=ColumnType.STRING, isNullable=false)
	private String capitano;
	@Column(name="modello", type=ColumnType.STRING, isNullable=false)
	private String modello;
	public String getCapitano() {
		return capitano;
	}
	public void setCapitano(String capitano) {
		this.capitano = capitano;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	
}

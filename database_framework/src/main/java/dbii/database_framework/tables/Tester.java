package dbii.database_framework.tables;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Tester {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="numero", type=ColumnType.INT)
	private int number;
	@Column(name="stringa", type=ColumnType.STRING)
	private String stringa;
	
	public String getStringa() {
		return stringa;
	}
	public void setStringa(String stringa) {
		this.stringa = stringa;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}

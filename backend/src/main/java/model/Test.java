package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Test {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="codice", type=ColumnType.STRING, isNullable=false)
	private String codice;
	@Column(name="punteggiomassimo", type=ColumnType.INT, isNullable=false)
	private int punteggio;
	@Column(name="nome", type=ColumnType.STRING, isNullable=false)
	private String nome;

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}

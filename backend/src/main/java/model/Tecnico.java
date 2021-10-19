package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Tecnico {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="codiceFiscale", type=ColumnType.STRING, isNullable=false)
	private String codiceFiscale;
	@Column(name="cognome", type=ColumnType.STRING, isNullable=false)
	private String cognome;
	@Column(name="nome", type=ColumnType.STRING, isNullable=false)
	private String nome;
	@Column(name="indirizzo", type=ColumnType.STRING, isNullable=false)
	private String indirizzo;
	@Column(name="telefono", type=ColumnType.STRING, isNullable=false)
	private String telefono;
	@Column(name="salario", type=ColumnType.DOUBLE, isNullable=false)
	private double salario;

	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}

package model;

import java.util.Date;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class PersonaleMarittimo {

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
	@Column(name="dataultimavisita", type=ColumnType.DATE, isNullable=false)
	private Date dataultimavisita;
	@Column(name="flgcapitano", type=ColumnType.STRING, isNullable=false)
	private String flgcapitano;
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
	public Date getDataultimavisita() {
		return dataultimavisita;
	}
	public void setDataultimavisita(Date dataultimavisita) {
		this.dataultimavisita = dataultimavisita;
	}
	public String getFlgcapitano() {
		return flgcapitano;
	}
	public void setFlgcapitano(String flgcapitano) {
		this.flgcapitano = flgcapitano;
	}

}

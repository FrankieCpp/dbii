package dbii.database_framework.tables;

import java.sql.Ref;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Impiegati {
/*
 	ident numeric(2),
	cf varchar(16),
	nome varchar(30),
	dove ref azienda
 */
	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="ident", type=ColumnType.INT)
	private int ident;
	@Column(name="cf", type=ColumnType.STRING)
	private String cf;
	@Column(name="nome", type=ColumnType.STRING)
	private String nome;
	@Column(name="dove", type=ColumnType.REF)
	private Ref dove;

	public int getIdent() {
		return ident;
	}
	public void setIdent(int ident) {
		this.ident = ident;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Ref getDove() {
		return dove;
	}
	public void setDove(Ref dove) {
		this.dove = dove;
	}
	
}

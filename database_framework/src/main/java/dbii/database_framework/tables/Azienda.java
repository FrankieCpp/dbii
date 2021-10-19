package dbii.database_framework.tables;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Azienda {
	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="NOOME", type=ColumnType.STRING)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

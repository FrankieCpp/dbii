package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class Users {

	//RICORDA SERVE UN COSTRUTTORE A ZERO PARAMETRI

	@Column(name="userid", type=ColumnType.STRING, isNullable=false)
	private String nick;
	@Column(name="password", type=ColumnType.STRING, isNullable=false)
	private String password;
	@Column(name="sessionKey", type=ColumnType.STRING, isNullable=false)
	private String sessionKey;

	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

}

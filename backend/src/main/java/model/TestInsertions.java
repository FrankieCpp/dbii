package model;

import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.enums.ColumnType;

public class TestInsertions {

	@Column(name="FIRSTNAME", type=ColumnType.STRING, isNullable=false)
	private String firstName;
	@Column(name="IDNUMBER", type=ColumnType.DOUBLE, isNullable=false)
	private double idNumber;
	@Column(name="DATACREAZIONE", type=ColumnType.STRING, isNullable=false)
	private String date;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public double getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(double idNumber) {
		this.idNumber = idNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}

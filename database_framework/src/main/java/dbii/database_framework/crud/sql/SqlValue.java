package dbii.database_framework.crud.sql;

import dbii.database_framework.crud.enums.ValueType;

/**
 * Manage values passed at the dml or query
 * @author OracleUser
 *
 */
public class SqlValue {
	private ValueType type;
	private Object value;

	public SqlValue(ValueType type, Object value) {
		super();
		this.type = type;
		this.value = value;
	}

	public ValueType getType() {
		return type;
	}

	public void setType(ValueType type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String toString() {
		String str = this.value != null ? "" + this.value: "null";
		if(this.value != null){
			switch(this.getType()){
			case INT:
			case DOUBLE:
			case BOOLEAN:
				break;
			case DATE:
			case STRING:
				str = "'" + str + "'";
				break;
			case REF:
				str = this.value.toString().toLowerCase();
				break;
			default:
				break;
			}
		} 
		return str;
	}
}

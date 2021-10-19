package dbii.database_framework.crud.enums;

public enum ValueType {
	INT(1),
	DOUBLE(2),
	STRING(3),
	BOOLEAN(4),
	DATE(5),
	NULL(6),
	REF(7);

	ValueType(int value){}
}

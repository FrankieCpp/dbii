package dbii.database_framework.crud.enums;

/**
 * Annotation data type
 * @author 640690
 *
 */
public enum ColumnType {
	INT(1),
	DOUBLE(2),
	STRING(3),
	BOOLEAN(4),
	DATE(5),
	REF(6);

	ColumnType(int value){}
}

package dbii.database_framework.crud.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dbii.database_framework.crud.enums.ColumnType;
import dbii.database_framework.crud.enums.DateFormat;
import dbii.database_framework.crud.enums.DateFormat;

/**
 * Annotation that identifies a mapping from a 
 * database table column and an attribute of a class
 * @author 640690
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	String name();
	ColumnType type();
	boolean isNullable() default true;
	String defaultValue() default "";
	DateFormat formatDate() default DateFormat.NONE;
}

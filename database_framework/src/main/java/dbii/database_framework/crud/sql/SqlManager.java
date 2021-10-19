package dbii.database_framework.crud.sql;

import dbii.database_framework.utils.DbmsException;

/**
 * Sql Map: have to contains all query that
 * the system uses
 * @author 640690
 *
 */
public interface SqlManager {
	/**
	 * Get the specific query identified by name;
	 * @param name
	 * @param classe
	 * @return Object query
	 */
	<T> Query<T> getQuery(Class<T> tableClass, String name, SqlValue... args) throws DbmsException;
	/**
	 * Get direct sql;
	 * @param name
	 * @param classe
	 * @return Object dml
	 */
	<T> Query<T> getDirectQuery(Class<T> tableClass, String sql) throws DbmsException;
	/**
	 * Get the specific dml identified by name;
	 * @param name
	 * @param classe
	 * @return Object dml
	 */
	Sql getDml(String name, SqlValue... args) throws DbmsException;
}

package dbii.database_framework.crud.sql;

import dbii.database_framework.utils.DbmsException;

/**
 * Generic Interface for query object
 * @author 640690
 *
 * @param <T>
 */
public class Query<T> extends Sql{
	/**
	 * table class
	 */
	private Class<T> tableClass;

	public Query(Class<T> tableClass, boolean direct, String sql) throws DbmsException {
		super(direct, sql);
		this.tableClass = tableClass;
	}

	public Query(Class<T> tableClass, String sql, SqlValue[] params) throws DbmsException {
		super(sql, params);
		this.tableClass = tableClass;
	}
	
	public Class<T> getTableClass() {
		return tableClass;
	}

	public void setTableClass(Class<T> tableClass) {
		this.tableClass = tableClass;
	}
}

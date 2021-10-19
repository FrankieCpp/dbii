package dbii.database_framework.crud;

import java.util.List;

import dbii.database_framework.crud.sql.Sql;
import dbii.database_framework.crud.sql.Query;
import dbii.database_framework.crud.sql.SqlManager;
import dbii.database_framework.utils.DbmsException;

/**
 * CRUD: Create - Read - Update - Delete
 * Generic interface framework
 * @author 640690
 *
 */
public interface Crud {

	public boolean startTransaction() throws DbmsException;
	public void insert(Sql dml) throws DbmsException;
	public void update(Sql dml) throws DbmsException;
	public void delete(Sql dml) throws DbmsException;
	public boolean endTransaction() throws DbmsException;
	public <T> List<T> read(Query<T> query) throws DbmsException;
	public SqlManager getSqlManager() throws DbmsException;

}
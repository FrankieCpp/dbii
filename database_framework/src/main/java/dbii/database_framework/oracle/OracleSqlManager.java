package dbii.database_framework.oracle;

import java.util.Locale;
import java.util.ResourceBundle;

import dbii.database_framework.crud.sql.Query;
import dbii.database_framework.crud.sql.Sql;
import dbii.database_framework.crud.sql.SqlManager;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;

public class OracleSqlManager implements SqlManager{

	protected ResourceBundle sqlManager;

	public OracleSqlManager() throws DbmsException {
		this("config.queries", "oracle");
	}

	public OracleSqlManager(String path, String...locale) throws DbmsException {
		Locale temp = Locale.getDefault();
		try{

			Locale.setDefault(new Locale(locale[0]));
			sqlManager = ResourceBundle.getBundle(path);
			Locale.setDefault(temp);
		} catch(Exception e){
			throw new DbmsException(e,"INVALID_SQL_MANAGER_CONNECTION");
		}
	}

	@Override
	public <T> Query<T> getQuery(Class<T> classe, String name, SqlValue... sqlValues) throws DbmsException{
		return new Query<T>(classe, this.sqlManager.getString(name),sqlValues);
	}

	@Override
	public <T> Query<T> getDirectQuery(Class<T> tableClass, String sql) throws DbmsException {
		return new Query<T>(tableClass, true, sql);
	}

	@Override
	public Sql getDml(String name,SqlValue... strings) throws DbmsException {
		return new Sql(this.sqlManager.getString(name),strings);
	}
}

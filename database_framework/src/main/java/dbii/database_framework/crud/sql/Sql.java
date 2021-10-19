package dbii.database_framework.crud.sql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbii.database_framework.utils.DbmsException;

public class Sql implements ISql {

	protected String sql;
	protected SqlValue[] params;
	protected String completeSql;
	protected boolean direct;

	public Sql(boolean direct, String sql) {
		this.sql = sql;
		this.completeSql = sql;
	}

	/**
	 * Create a sql string with params passed by arguments
	 * @param sql
	 * @param params
	 * @throws DbmsException
	 */
	public Sql(String sql, SqlValue[] params) throws DbmsException {
		this.sql = sql;
		this.params = params;
		long count = sql.chars().filter(e -> e == '?').count();
		long length = params != null ? params.length : 0l;
		if (count == length) {
			if(count > 0) {
				StringBuffer sb = new StringBuffer();
				Pattern p = Pattern.compile("\\?");
				Matcher m = p.matcher(this.sql);
				for(int i=0; m.find(); i++) {
					m.appendReplacement(sb, this.params[i].toString());
				}
				m.appendTail(sb);
				this.completeSql = sb.toString();
			} else {
				this.completeSql = this.sql;
			} 
		} else {
			throw new DbmsException("DIFFERENT_ARUGMENTS_NUMBER");
		}
	}

	public SqlValue[] getParams() {
		return params;
	}

	public String getInitialSql() {
		return sql;
	}
	
	public String getSql() {
		return this.completeSql;
	}
}

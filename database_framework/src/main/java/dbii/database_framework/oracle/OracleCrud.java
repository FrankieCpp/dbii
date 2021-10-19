package dbii.database_framework.oracle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dbii.database_framework.connector.DbmsConnector;
import dbii.database_framework.crud.Crud;
import dbii.database_framework.crud.annotations.Column;
import dbii.database_framework.crud.sql.Sql;
import dbii.database_framework.crud.sql.ISql;
import dbii.database_framework.crud.sql.Query;
import dbii.database_framework.crud.sql.SqlManager;
import dbii.database_framework.utils.DbmsException;

public class OracleCrud implements Crud {

	protected Connection connector;
	protected Statement statement;
	protected List<ISql> operations;

	public OracleCrud() throws DbmsException {
		this("config.dbms","oracle");
	}

	public OracleCrud(String path, String...connections) throws DbmsException {
		try {
			DbmsConnector conn = null;
			switch(connections.length){
			case 0:
				conn = DbmsConnector.getInstance(path);
			case 1:
				conn = DbmsConnector.getInstance(path, connections[0]);
			break;
			case 2:
				conn = DbmsConnector.getInstance(path, connections[0],connections[1]);
			break;
			case 3:
				conn = DbmsConnector.getInstance(path, connections[0],connections[1],connections[2]);
			break;
			default:
				throw new DbmsException("INVALID_CRUD_CONNECTION");
			}
			Class.forName(conn.getDriver());
			String dbPath = conn.getPath();
			String username = conn.getUsername();
			String password = conn.getPassword();
			this.connector = DriverManager.getConnection(dbPath, username, password);
			this.statement = this.connector.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbmsException(e, "ERROR_CRUD_CONNECTION");
		}
	} 

	public <T> List<T> read(Query<T> query) throws DbmsException{
		String sql = query.getSql();
		Class<T> tableClass = query.getTableClass();
		List<T> res = new LinkedList<T>();
		try {
			ResultSet rs = this.statement.executeQuery(sql);
			while(rs.next()){
				Constructor<T> con = tableClass.getConstructor();
				T temp = (T) con.newInstance();
				Field[] fields = tableClass.getDeclaredFields();
				for(int i = 0; i < fields.length; i++) {
					Field f =fields[i];
					Object value = null;
					if(f.isAnnotationPresent(Column.class)){
						Column row = f.getAnnotation(Column.class);
						switch(row.type()){
						case INT:
							value = rs.getInt(row.name());
							break;
						case DOUBLE:
							value = rs.getDouble(row.name());
							break;
						case STRING:
							value = rs.getString(row.name());
							break;
						case BOOLEAN:
							value = rs.getBoolean(row.name());
							break;
						case DATE:
							value = rs.getDate(row.name());
							break;
						case REF:
							value = rs.getRef(row.name());
							break;
						default:
							value = null;
							break;
						}
						String nameField = f.getName();
						nameField = nameField.substring(0, 1).toUpperCase() + nameField.substring(1);
						for(Method met : tableClass.getMethods()){
							if(met.getName().equals("set"+nameField)){
								met.invoke(temp, value);
							}
						}
					}
				}
				res.add(temp);
			}
		} 
		catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException |NoSuchMethodException | SecurityException e) {
			throw new DbmsException(e);
		}

		return res;

	}

	public Connection getConnector(){
		return this.connector;
	}

	@Override
	public boolean startTransaction() throws DbmsException {
		this.operations = new LinkedList<ISql>();
		return true;
	}

	@Override
	public void insert(Sql dml) throws DbmsException {
		this.addDml(dml);
	}

	@Override
	public void update(Sql dml) throws DbmsException {
		this.addDml(dml);
	}

	@Override
	public void delete(Sql dml) throws DbmsException {
		this.addDml(dml);
	}

	@Override
	public boolean endTransaction() throws DbmsException {
		try {
			if(this.operations != null){
				this.operations.stream().map((dml)->dml.getSql()).allMatch((sql)->{
					try {
						return this.executeDml(sql);
					} catch (DbmsException e) {
						throw new RuntimeException(e);
					}
				});
				this.executeDml("COMMIT");
			}  
		} catch (Exception e) {
			this.executeDml("ROLLBACK");
			throw new DbmsException(e);
		} finally {
			this.operations = null;
		}
		return true;
	}

	@Override
	public SqlManager getSqlManager() throws DbmsException {
		return new OracleSqlManager();
	}

	public SqlManager getSqlManager(String path, String... locale) throws DbmsException {
		return new OracleSqlManager(path, locale);
	}
	/************************
	* PRIVATE METHODS
	*************************/
	private void addDml(Sql dml) throws DbmsException{
		if(this.operations == null)
			this.startTransaction();

		this.operations.add(dml);		
	}

	private boolean executeDml(String sql) throws DbmsException {
		try {
			this.statement.executeQuery(sql);
		} catch (SQLException e) {
			throw new DbmsException(e);
		}
		return true;
	}
}

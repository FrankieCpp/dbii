package dbii.backend;

import dbii.database_framework.crud.Crud;
import dbii.database_framework.crud.enums.Dbms;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlManager;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.Crypter;
import dbii.database_framework.utils.DbmsException;
import dbii.database_framework.utils.DbmsFactory;

public class UsersLoading {

	public static void main(String[] args){
		System.out.println("Loading Users");
		try{
			Crud crud = DbmsFactory.getInstance(Dbms.ORACLE);
			SqlManager sql = crud.getSqlManager();			
			SqlValue value1 = new SqlValue(ValueType.STRING,"nopwd");
			System.out.println(Crypter.encode("nopwd"));
			SqlValue value2 = new SqlValue(ValueType.STRING,Crypter.encode("nopwd"));
			SqlValue value3 = new SqlValue(ValueType.NULL, null);
			crud.insert(sql.getDml("INSERT_USER", value1, value2, value3));
			crud.endTransaction();
			System.out.println("Loading Loaded");
		} catch (DbmsException e) {
			System.out.println("Loading NOT Loaded");
			e.printStackTrace();
		} 

	}

}
package dbii.database_framework.utils;

import dbii.database_framework.crud.Crud;
import dbii.database_framework.crud.enums.Dbms;
import dbii.database_framework.oracle.OracleCrud;

public abstract class DbmsFactory {

	public static Crud getInstance(Dbms dbms) throws DbmsException {
		Crud crud = null;
		switch(dbms){
		case ORACLE:
			crud = new OracleCrud();
			break;
		case TEST:
			crud = new OracleCrud("config.dbms","test");
			break;
		default:
			throw new DbmsException("DBMS_FACTORY_ERROR");
		}
		return crud;
	}
}

package dbii.database_framework;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import dbii.database_framework.connector.DbmsConnector;
import dbii.database_framework.crud.Crud;
import dbii.database_framework.crud.enums.Dbms;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlManager;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.oracle.OracleCrud;
import dbii.database_framework.tables.Azienda;
import dbii.database_framework.tables.Impiegati;
import dbii.database_framework.tables.Tester;
import dbii.database_framework.utils.DbmsException;
import dbii.database_framework.utils.DbmsFactory;
/*
 * create table tester(numero numeric(2));
 * insert into tester values(1);
 * commmit;
 */
public class Tests {

	@Test
	public void Test1() {
		System.out.println("Test 1 - connessione e creazione");
		DbmsConnector c;
		try {
			c = DbmsConnector.getInstance("config.dbms","test");
			assertEquals(c.getDriver(), "oracle.jdbc.driver.OracleDriver");
			Class.forName(c.getDriver());
			String path = c.getPath();
			String username = c.getUsername();
			String password = c.getPassword();

			Connection conn = DriverManager.getConnection(path, username, password);

			Statement stmt = conn.createStatement();
			try{
				stmt.execute("DROP TABLE tester");
			}
			catch(Exception e){
				//There is not table
			}
			String stringa = GenericVariable.stringa;
			int numero = GenericVariable.intero;
			stmt.execute("create table tester(numero numeric(2), stringa varchar(30))");
			stmt.execute("insert into tester values(" + Integer.toString(numero) + ",'" + stringa + "')");
			stmt.execute("commit");

			String sql  = "SELECT * FROM tester";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("numero");
				assertEquals(id,numero);
				String str = rs.getString("stringa");
				assertEquals(str,stringa);

			}
		} catch (DbmsException | SQLException | ClassNotFoundException e) {
			assertEquals("",e.getMessage());
		} 
		assertEquals(true,true);

	}

	@Test
	public void Test2() {
		System.out.println("Test 2 - dml");
		try{
			Crud crud = DbmsFactory.getInstance(Dbms.TEST);
			SqlManager sql = ((OracleCrud)crud).getSqlManager("config.queries","test");
			crud.insert(sql.getDml("TESTING_INSERT_FIX"));
			SqlValue value2 = new SqlValue(ValueType.STRING,"Maria Francesca");
			crud.update(sql.getDml("TESTING_UPDATE", value2));
			crud.endTransaction();
		} catch (DbmsException e) {
			assertEquals("",e.getMessage());
		} 
		assertEquals(true,true);
	}

	@Test
	public void Test3() {
		System.out.println("Test 3 - query");
		try{
			Crud crud = DbmsFactory.getInstance(Dbms.TEST);
			SqlManager sql = ((OracleCrud)crud).getSqlManager("config.queries","test");
			SqlValue value = new SqlValue(ValueType.STRING,"Maria Francesca");
			List<Tester> list = crud.read(sql.getQuery(Tester.class, "TESTING_SELECT", value));
			for(Tester t: list){
				assertEquals(t.getStringa(),"Maria Francesca");
			}
		} catch (DbmsException e) {
			assertEquals("",e.getMessage());
		} 
	}
//	
//	@Test
//	public void Test4() {
//		System.out.println("Test 1 - connessione e creazione");
//		DbmsConnector c;
//		try{
//			Crud crud = DbmsFactory.getInstance(Dbms.TEST);
//			SqlManager sql = ((OracleCrud)crud).getSqlManager("config.queries","test");
//
//			List<Impiegati> list = crud.read(sql.getQuery(Impiegati.class,"TESTING_READ_IMPIEGATI"));
//			Ref e = null; 	
//			for(Impiegati imp : list){
//				System.out.println(imp.getDove());
//				e = imp.getDove();
//			}
//			
//			List<Azienda> list2 = crud.read(sql.getQuery(Azienda.class,"TEST_FROM_REF"));
//			
//			for(Azienda imp : list2){
//				assertEquals(imp.getNome(),"reply");
//			}
//			SqlValue value = new SqlValue(ValueType.REF,e);
//			List<Azienda> list3 = crud.read(sql.getQuery(Azienda.class, "TESTING_READ_AZIENDA_FROM_IMPIEGATI", value));
//			for(Azienda t: list3){
//				assertEquals(t.getNome(),"reply");
//			}
//		} catch (Exception e) {
//			assertEquals("",e.getMessage());
//		} 
//
//		assertEquals(true,true);
//
//	}
}
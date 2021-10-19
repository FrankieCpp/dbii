package dbii.database_framework.connector;

import java.util.Locale;
import java.util.ResourceBundle;

import dbii.database_framework.utils.DbmsException;

/**
 * Extracts configuration data for dbms access
 * @author 640690
 *
 */
public class DbmsConnector {
	private ResourceBundle bundle;

	/**
	 * 
	 * @param domain
	 * @throws DbmsException
	 */
	private DbmsConnector(String path, String... domain) throws DbmsException {
		int length = domain.length;
		Locale locale = Locale.getDefault();
		switch(length){
		case 1:
			Locale.setDefault(new Locale(domain[0]));
			break;
		case 2:
			Locale.setDefault(new Locale(domain[0],domain[1]));
			break;
		case 3:
			Locale.setDefault(new Locale(domain[0],domain[1],domain[2]));
			break;
		default:
			throw new DbmsException("DBMS_NEW_CONNECTION_ERROR");
		}
		this.bundle = ResourceBundle.getBundle(path);
		Locale.setDefault(locale);
	}

	/**********************************************
	 * Returns the instance of DbmsConnector
	 * @return
	 * @throws DbmsException
	 **********************************************/
	public static synchronized DbmsConnector getInstance() throws DbmsException{
		return DbmsConnector.getInstance("dbms");
	}

	public static synchronized DbmsConnector getInstance(String path) throws DbmsException{
		return new DbmsConnector(path);
	}

	public static synchronized DbmsConnector getInstance(String path, String... domain) throws DbmsException{
		return new DbmsConnector(path, domain);
	}

	/*************************************************
	 * Returns params of the database
	 * @return
	 * @throws DbmsException
	 *************************************************/
	public String getDriver() throws DbmsException {
		return this.getProperties("dbms.driver","READ_DRIVER_ERROR");
	}

	public String getPath() throws DbmsException {
		return this.getProperties("dbms.path","READ_PATH_ERROR");
	}

	public String getUsername() throws DbmsException {
		return this.getProperties("dbms.username","READ_USERNAME_ERROR");
	}

	public String getPassword() throws DbmsException {
		return this.getProperties("dbms.password","READ_PASSWORD_ERROR");
	}

	/* *******************************
	 * PRIVATE METHODS
	 ***************************** */
	private String getProperties(String property, String message) throws DbmsException {
		String str = null;
		try{
			str = this.bundle.getString(property);
		} catch(Exception e){
			throw new DbmsException(e, message);
		}
		return str;
	}
}

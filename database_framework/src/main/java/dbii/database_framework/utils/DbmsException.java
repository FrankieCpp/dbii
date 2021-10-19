package dbii.database_framework.utils;

public class DbmsException extends Exception {

	private static final long serialVersionUID = 593105617423729505L;
	private String msg;

	public DbmsException(){
		super();
	}

	public DbmsException(Exception e){
		super(e);
	}

	public DbmsException(String msg){
		super();
		this.msg = msg;
	}

	public DbmsException(Exception e,String msg){
		super(e);
		this.msg = msg;
	}

	public String getMessage(){
		String message = super.getMessage();
		StringBuilder str = new StringBuilder(message != null? message : "");
		
		if(message != null && message.length() > 0)
			str.append(" - ");

		str.append(this.msg);
		return  str.toString();
	}
	
	public String getOwnMessage() {
		return this.msg;
	}
}

package dbii.database_framework.utils;

import java.util.Base64;

public class Crypter {
	
	public synchronized static String encode(String str){
		return new String(Base64.getEncoder().encode(str.getBytes()));
	}
	
	public synchronized static String decode(byte[] str){
		return new String(Base64.getDecoder().decode(str));
	}
}

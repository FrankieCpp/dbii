package utils;

import java.util.Random;

public class Helpers {
	public static boolean isStringEmpty(String str){
		return str == null || str.length() == 0;
	}
	
	
	public static boolean areNotStringsEmpty(String... strs){
		boolean check = true;
		int i = 0;
		while(check && i < strs.length){
			String str = strs[i++];
			check = !Helpers.isStringEmpty(str);
		}
		return check;
	}

	public static String getRandomString(int length){
		Random random = new Random();	
		return random.ints(48,122)
                .filter(i-> (i<57 || i>65) && (i <90 || i>97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
	}
	
	public static String trunc(String stringa, int length){
		return length < stringa.length()? stringa.substring(0, length): stringa;
	}
}

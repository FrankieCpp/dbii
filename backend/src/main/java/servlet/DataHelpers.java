package servlet;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataHelpers {

	public static List<String> nomi= new LinkedList<String>();
	static {
		nomi.add("Francesco");
		nomi.add("Francesca");
		nomi.add("Domenico");
		nomi.add("Mario");
		nomi.add("Giorgio");
		nomi.add("Giovanni");
		nomi.add("Davide");
		nomi.add("Vincenzo");
		nomi.add("Loredana");
		nomi.add("Laura");
		nomi.add("Roberta");
	}
	
	public static List<String> cognomi= new LinkedList<String>();
	static {
		cognomi.add("Coppi");
		cognomi.add("Ronco");
		cognomi.add("Luisi");
		cognomi.add("Lombardo");
		cognomi.add("Vanni");
		cognomi.add("Lombardo");
		cognomi.add("Nicassio");
		cognomi.add("Susca");
		cognomi.add("Palmisano");
		cognomi.add("Palazzo");
		cognomi.add("Rossi");
	}
	
	public static double getNubmer(int max) {
		return DataHelpers.getNubmer(1, max);
	}
	public static double getNubmer(int min, int max) {
		return Math.floor((Math.random()*(max -min) + min));
	}
	
	public static String getStringData() {
		int day = (int) DataHelpers.getNubmer(1,30);
		int mounth = (int) DataHelpers.getNubmer(1,12);
		int year = (int) DataHelpers.getNubmer(1990,2018);
		
		if(mounth == 2 && day > 28)
			day = 28;
		String date = Integer.toString(year);
		date = date +  "-" + (mounth < 10?"0":"")+Integer.toString(mounth);
		date = date + "-" + (day < 10?"0":"")+Integer.toString(day);
		return date;
	}
	
	public static String getStringTime() {
		int minutes = (int) DataHelpers.getNubmer(0,59);
		int hours = (int) DataHelpers.getNubmer(1,23);
		String date = (hours < 10?"0":"")+Integer.toString(hours);
		date = date + ":" + (minutes < 10?"0":"")+Integer.toString(minutes);
		return date;
	}
	
	public static String generateCode() {
		String code = DataHelpers.generateRandomString(6).toUpperCase();
		code += Integer.toString((int)DataHelpers.getNubmer(80, 99));
		code += DataHelpers.generateRandomString(1).toUpperCase();
		code += Integer.toString((int)DataHelpers.getNubmer(10, 30));
		code += DataHelpers.generateRandomString(1).toUpperCase();
		code += Integer.toString((int)DataHelpers.getNubmer(100, 999));
		code += DataHelpers.generateRandomString(1).toUpperCase();
		return code;
	}
	
	public static String generateRandomString(int length){
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
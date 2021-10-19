package utils;

import java.util.ResourceBundle;


public class Config {
	public static Config manager;
	private ResourceBundle configs;

	public static synchronized Config getInstance() {
		return new Config();
	}

	public String get(String label) {
		String upper = label == null?"":label.toUpperCase();
		String lbl = "";
		if(upper.trim().length() > 0)
			lbl = this.configs.getString(upper);
		return lbl;
	}
	
	private Config(){
		if(configs == null){
			this.configs = ResourceBundle.getBundle("config.params");
		}
	}
}

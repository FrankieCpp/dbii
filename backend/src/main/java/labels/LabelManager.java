package labels;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbii.database_framework.utils.DbmsException;

public class LabelManager {

	public static LabelManager manager;
	private ResourceBundle languageMap;

	public static synchronized LabelManager getInstance() {
		return LabelManager.getInstance("ita");
	}

	public static synchronized LabelManager getInstance(String language) {
		if(manager == null)
			manager = new LabelManager(language);
		return manager;
	}

	public String get(String label) {
		String upper = label == null?"":label.toUpperCase();
		String lbl = "";
		if(upper.trim().length() > 0)
			lbl = this.languageMap.getString(upper);
		return lbl;
	}

	public String getParametrized(String label, String...values) throws DbmsException {
		String lbl = this.get(label);
		String completeLbl = null;
		long count = lbl.split("@#§").length-1;
		long length = values != null ? values.length : 0l;
		if (count == length) {
			if(count > 0) {
				StringBuffer sb = new StringBuffer();
				Pattern p = Pattern.compile("\\?");
				Matcher m = p.matcher(lbl);
				for(int i=0; m.find(); i++) {
					m.appendReplacement(sb, values[i]);
				}
				m.appendTail(sb);
				completeLbl = sb.toString();
			} else {
				completeLbl = lbl;
			} 
		} else {
			throw new DbmsException("DIFFERENT_ARUGMENTS_LABEL_PARAMS");
		}
		return completeLbl;
	}

	
	private LabelManager(String language){
		if(languageMap == null){
			Locale locale = Locale.getDefault();
			Locale.setDefault(new Locale(language));
			this.languageMap = ResourceBundle.getBundle("config.lang");
			Locale.setDefault(locale);
		}
	}
}

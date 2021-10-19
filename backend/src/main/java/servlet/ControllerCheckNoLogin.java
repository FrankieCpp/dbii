package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Config;
import utils.ResponseType;

public class ControllerCheckNoLogin extends ControllerBase {

	private static final long serialVersionUID = 1L;

	/** 
	 * parameters:
	 * 	username
	 *  pwd
	 * @throws Exception 
	 */
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean found = null;

		Config config = Config.getInstance();
		String noPwd = config.get("NOPWD");

		setJsonResponse(response, "0".equals(noPwd)?"1":"0","");
	}

	public String getServletName() {
		return "ControllerNoPwd";
	}

	@Override
	protected boolean setControllerValidation(HttpServletRequest request) {
		return true;
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}

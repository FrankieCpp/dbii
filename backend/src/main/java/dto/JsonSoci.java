package dto;

import java.util.List;

import model.Socio;

public class JsonSoci extends JsonResponse {
	private List<Socio> soci;

	public List<Socio> getSoci() {
		return soci;
	}

	public void setSoci(List<Socio> soci) {
		this.soci = soci;
	}
	
	
}

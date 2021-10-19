package dto;

import java.util.List;

import model.Tecnico;

public class JsonTecnici extends JsonResponse {
	private List<Tecnico> tecnici;

	public List<Tecnico> getTecnici() {
		return tecnici;
	}

	public void setTecnici(List<Tecnico> tecnici) {
		this.tecnici = tecnici;
	}
}

package dto;

import java.util.List;

import model.Modello;

public class JsonModelli extends JsonResponse {
	private List<Modello> modelli;

	public List<Modello> getModelli() {
		return modelli;
	}

	public void setModelli(List<Modello> modelli) {
		this.modelli = modelli;
	}
}

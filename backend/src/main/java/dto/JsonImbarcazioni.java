package dto;

import java.util.List;

import model.ImbarcazioneArchivio;

public class JsonImbarcazioni extends JsonResponse {
	private List<ImbarcazioneArchivio> imbarcazioni;

	public List<ImbarcazioneArchivio> getImbarcazioni() {
		return imbarcazioni;
	}

	public void setImbarcazioni(List<ImbarcazioneArchivio> imbarcazioni) {
		this.imbarcazioni = imbarcazioni;
	}

}

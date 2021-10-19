package dto;

import java.util.List;

import model.PersonaleMarittimo;

public class JsonCapitani extends JsonResponse {
	private List<PersonaleMarittimo> capitani;

	public List<PersonaleMarittimo> getCapitani() {
		return capitani;
	}

	public void setCapitani(List<PersonaleMarittimo> capitani) {
		this.capitani = capitani;
	}

}

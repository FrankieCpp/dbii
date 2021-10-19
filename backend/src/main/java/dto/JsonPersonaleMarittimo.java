package dto;

import java.util.List;

import model.PersonaleMarittimo;

public class JsonPersonaleMarittimo extends JsonResponse {
	private List<PersonaleMarittimo> personameMarittimo;

	public List<PersonaleMarittimo> getPersonameMarittimo() {
		return personameMarittimo;
	}

	public void setPersonameMarittimo(List<PersonaleMarittimo> personameMarittimo) {
		this.personameMarittimo = personameMarittimo;
	}
}

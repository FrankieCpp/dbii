package dto;

import java.util.List;

import model.Test;

public class JsonTest extends JsonResponse {
	private List<Test> test;

	public List<Test> getTest() {
		return test;
	}

	public void setTest(List<Test> test) {
		this.test = test;
	}

}

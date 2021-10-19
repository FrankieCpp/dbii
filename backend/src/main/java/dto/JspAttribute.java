package dto;

public class JspAttribute<T> {
	private String name;
	private T object;
	
	public JspAttribute(String name, T object){
		this.name = name;
		this.object = object;
	}
	
	public T getObject(){
		return object;
	}
	
	public String getName(){
		return name;
	}
}

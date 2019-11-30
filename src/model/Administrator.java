package model;

public class Administrator {
	private String id=null;
	private String name=null;
	public Administrator(String id,String name) {
		this.id=id;
		this.name=name;
	}
	public Administrator() {};
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
	    this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}

}

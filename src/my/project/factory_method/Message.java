package my.project.factory_method;

public abstract class Message {
	
	public abstract String getContent();
	
	public void addDefaultHeaders() {
		//add default headers
	}
	
	public void encrypt() {
		//has some code to encrypt the content
	}

}

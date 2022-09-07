package my.project.facade;

public class EmailBuilder {

	public EmailBuilder withTemplate(Template template) {
		// TODO Auto-generated method stub
		return this;
	}
	
	public EmailBuilder withStationary(Stationary stationary) {
		return this;
	}
	
	public EmailBuilder forObject(Order order) {
		return this;
	}
	
	public Email build() {
		return null;
	}

}

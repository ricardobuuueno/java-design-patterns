package my.project.facade;

import my.project.facade.Template.TemplateType;

public class EmailFacade {

	public boolean sendOrderEmail(Order order) {
		Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
		Stationary stationary = StationaryFactory.createStationary();
		Email email = Email.getBuilder()
				.withTemplate(template)
				.withStationary(stationary)
				.forObject(order)
				.build();
		Mailer mailer = Mailer.getMailer();
		return mailer.send(email);		
	}
	
}

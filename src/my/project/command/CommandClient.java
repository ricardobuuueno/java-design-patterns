package my.project.command;

public class CommandClient {

	public static void run() {
		try {
			EWSService service = new EWSService();
			
			Command c1 = new AddMemberCommand("a@a", "spam", service);
			MailTaskRunner.getInstance().addCommand(c1);
			
			Command c2 = new AddMemberCommand("b@b", "spam", service);
			MailTaskRunner.getInstance().addCommand(c2);
			
			Thread.sleep(3000);
			
			MailTaskRunner.getInstance().shutdown();
		}
		catch (InterruptedException e) {
			
		}
	}
	
}

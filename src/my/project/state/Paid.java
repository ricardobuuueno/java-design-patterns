package my.project.state;

public class Paid implements OrderState {

	@Override
	public double handleCancelation() {
		System.out.println("Contacting payment gateway to rollback transaction.");
		return 10;
	}

}

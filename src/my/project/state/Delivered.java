package my.project.state;

public class Delivered implements OrderState {

	@Override
	public double handleCancelation() {
		System.out.println("Contacting courier service for item pickup.");
		System.out.println("Payment rollback will be initiated upon receiving returned item.");
		return 30;
	}

}

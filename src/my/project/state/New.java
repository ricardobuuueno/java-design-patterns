package my.project.state;

public class New implements OrderState {

	@Override
	public double handleCancelation() {
		System.out.println("It's a new Order. No processing done.");
		return 0;
	}

}

package my.project.state;

public class Cancelled implements OrderState {

	@Override
	public double handleCancelation() {
		throw new IllegalStateException("Cancelled order. Can't cancel anymore.");
	}

}

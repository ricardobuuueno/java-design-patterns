package application.pattern.mediator;

public class Slider extends javafx.scene.control.Slider implements UIControl {

	private UIMediator mediator;
	private boolean mediatedUpdate;
	
	public Slider(UIMediator mediator) {
		this.mediator = mediator;
		setMin(0);
		setMax(50);
		setBlockIncrement(5);
		mediator.register(this);
		this.valueProperty().addListener((v, o, n) -> {
			if (!mediatedUpdate) {
				this.mediator.valueChanged(this);
			}
		});
	}
	
	@Override
	public void controlChanged(UIControl control) {
		this.mediatedUpdate = true;
		this.setValue(Double.valueOf(control.getControlValue()));
		this.mediatedUpdate = false;
	}

	@Override
	public String getControlValue() {
		return Double.toString(getValue());
	}

	@Override
	public String getControlName() {
		return "Slider";
	}

}

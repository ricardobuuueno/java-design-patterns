package application.pattern.mediator;

public interface UIControl {

	void controlChanged(UIControl control);
	
	String getControlValue();
	
	String getControlName();
	
}

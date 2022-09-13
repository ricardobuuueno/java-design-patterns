package my.project.memento;

public class RemoveStepCommand extends AbstractWorkflowCommand {

	private String step;
	
	public RemoveStepCommand(WorkflowDesigner designer, String step) {
		super(designer);
		this.step = step;
	}

	@Override
	public void execute() {
		this.memento = receiver.getMemento();
		receiver.removeStep(step);
	}

}

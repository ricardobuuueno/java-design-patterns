package my.project.memento;

public interface WorkflowCommand {

	void execute();
	
	void undo();
	
}
